package com.zonkafeedback.zfsdk.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;

import com.zonkafeedback.zfsdk.Constant;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Objects;
import java.util.TimeZone;

public class AppUtils {

    private static final class AppUtilsHolder {
        static final AppUtils appUtils = new AppUtils();
    }

    public static AppUtils getInstance() {

        return AppUtilsHolder.appUtils;
    }


    /**
     * this function return the Application version code
     *
     * @param mContext
     * @return
     */
    public String getAppVersionCode(Context mContext) {
        int versionCode = 0;
        try {
            versionCode = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return Integer.toString(versionCode);
    }


    public String getDeviceId(Context mContext) {
        @SuppressLint("HardwareIds") String android_id = Settings.Secure.getString(mContext
                .getContentResolver(), Settings.Secure.ANDROID_ID);
        if (android_id != null) {
            return android_id;
        } else {
            return " ";
        }
    }

    /**
     * This function return the serial number of users devices.
     *
     * @return
     */
    public String getDeviceSerial() {
        final String Serial_No = Build.SERIAL;
        if (Serial_No != null) {
            return Serial_No;
        } else {
            return " ";
        }
    }

    public String getDeviceIMEI(Application context) {
        final String IMEI_No = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        if (IMEI_No != null) {
            return IMEI_No;
        } else {
            return " ";
        }
    }

    /**
     * This function calculate the device length in form of width and height.
     *
     * @param mContext
     * @return
     */
    public String getDeviceResolution(Context mContext) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels + "*" + metrics.heightPixels;
    }


    /**
     * This function get the ip address used by user.
     *
     * @return
     */
    public String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * This function return the type of network used by user.
     *
     * @param mContext
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String get_network(Application mContext) {
        String network_type = "UNKNOWN";
        NetworkInfo active_network = ((ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo();
        if (active_network != null && active_network.isConnectedOrConnecting()) {
            if (active_network.getType() == ConnectivityManager.TYPE_WIFI) {
                network_type = "WIFI";
            } else if (active_network.getType() == ConnectivityManager.TYPE_MOBILE) {
                network_type = Objects.requireNonNull(((ConnectivityManager) mContext
                        .getSystemService(Context.CONNECTIVITY_SERVICE))
                        .getActiveNetworkInfo()).getSubtypeName();
            }
        }
        return network_type;
    }

    /**
     * This function check the type of device weather it is mobile or tablet.
     *
     * @param context
     * @return
     */
    public boolean isTablet(Application context) {
        boolean xlarge = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == 4);
        boolean large = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE);
        return (xlarge || large);
    }


    /**
     * This function check weather internet is available or not.
     *
     * @param mContext
     * @return
     */
    public boolean isNetworkConnected(Application mContext) {
        ConnectivityManager cm =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }


    /**
     * This method get all the Mobile related information and stored in hashmap to pass it on server.
     *
     * @param mContext
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public HashMap<String, Object> getHiddenVariables(Application mContext) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Constant.APP_VERSION_CODE, AppUtils.getInstance().getAppVersionCode(mContext));
        hashMap.put(Constant.DEVICE_RESOLUTION, AppUtils.getInstance().getDeviceResolution(mContext));
        //   hashMap.put(Constant.DEVICE_IMEI, AppUtils.getInstance().getDeviceEMIE(mContext));
        hashMap.put(Constant.DEVICE_SERIAL, AppUtils.getInstance().getDeviceSerial());
        hashMap.put(Constant.GET_NETWORK, AppUtils.getInstance().get_network(mContext));
        hashMap.put(Constant.DEVICE_NAME, Build.MODEL);
        hashMap.put(Constant.DEVICE_MODEL, Build.MODEL);
        hashMap.put(Constant.DEVICE_BRAND, Build.BRAND);
        hashMap.put(Constant.TIME_ZONE, TimeZone.getDefault().getID());
        hashMap.put(Constant.DEVICE_TYPE, AppUtils.getInstance().isTablet(mContext) ? "Tablet" : "Mobile");
        hashMap.put(Constant.DEVICE_OS, Constant.ANDROID);
        hashMap.put(Constant.APP_VERSION_NAME, "1.0");
        hashMap.put(Constant.DEVICE_OS_VERSION, Build.VERSION.RELEASE);
        return hashMap;
    }


    /**
     * This function used to calculate time difference from current time in seconds.
     */
    public boolean calculateDifferenceTime(long createdDateInMS) {

        long currentDateInMS = System.currentTimeMillis();
        long difference = currentDateInMS - createdDateInMS;
        long secondsInMilli = 1000;

        if (difference == 0)
            return true;

        long elapsedSeconds = difference / secondsInMilli;

        return elapsedSeconds <= 20;
    }

    /**
     * Create a desire time format by passing the time stamp in form of milliseconds as a parameter.
     * @param timeStamp
     * @param format
     * @return
     */
    public String getCurrentTime(long timeStamp, String format) {
        long utcTime = 0L;
        try {

          utcTime = getCurrentUtcTime(timeStamp);

        }catch (ParseException e){

        }

        return timeStampToDate(utcTime, format);
    }

    private String timeStampToDate(long timeStamp, String format){
        String time = DateFormat.format(format, timeStamp).toString();
        Log.d("formatted_time",time);
         return time;
    }

    // create getCurrentUtcTime() method to get the current UTC time
    private long getCurrentUtcTime(long timeStamp) throws ParseException {  // handling ParseException
        // create an instance of the SimpleDateFormat class
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        // set UTC time zone by using SimpleDateFormat class
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        //create another instance of the SimpleDateFormat class for local date format
        SimpleDateFormat ldf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        // declare and initialize a date variable which we return to the main method
        Date d1 = null;
        // use try catch block to parse date in UTC time zone
        try {
            // parsing date using SimpleDateFormat class
            d1 = ldf.parse( sdf.format(new Date(timeStamp)) );
        }
        // catch block for handling ParseException
        catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        // pass UTC date to main method.
        return d1.getTime();
    }


    /**
     * This function calls when sdk initialized and  creates an anonymous Id for the user.
     */
    public String getCookieId(int length) {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz"+ "0123456789";

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

}
