package com.zonkafeedback.zfsdk.retrofit;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.zonkafeedback.zfsdk.Constant;
import com.zonkafeedback.zfsdk.database.Sessions;
import com.zonkafeedback.zfsdk.interfaces.ApiResponseCallbacks;
import com.zonkafeedback.zfsdk.model.contactResponse.ContactResponse;
import com.zonkafeedback.zfsdk.model.eventModel.EventRequest;
import com.zonkafeedback.zfsdk.model.sessionRequestModel.SessionLog;
import com.zonkafeedback.zfsdk.model.sessionRequestModel.UpdateSessionRequest;
import com.zonkafeedback.zfsdk.model.sessionResponseModel.SessionResponse;
import com.zonkafeedback.zfsdk.model.widgetResponse.Widget;
import com.zonkafeedback.zfsdk.sharedpreference.PreferenceManager;
import com.zonkafeedback.zfsdk.utils.AppUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import okhttp3.ResponseBody;

/**
 * This class act as an model class. Which connects with our remote and local databases. Also write
 * the business logic to save and fetch all the survey information.
 */
public class DataManager {

    private static DataManager instance;
    private ApiManager apiManager;
    private ApiResponseCallbacks callbacks;
    private String zfRegion ="";

    /**
     * @return instance
     */
    public static DataManager getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Call init() before getInstance()");
        }
        return instance;
    }

    /**
     * This function is initialization data manager class.
     */
    public synchronized static DataManager init(Context context, String token) {
        if (instance == null) {
            instance = new DataManager();
            PreferenceManager.init(context, token);
        }
        return instance;
    }

    public void setApiCallbacks(ApiResponseCallbacks callbacks) {
        this.callbacks = callbacks;
    }

    /**
     * Method to initialize {@link ApiManager} class
     */
    public void initApiManager() {
        apiManager = ApiManager.getInstance();
    }


    /**
     * This function check weather survey widget is active or inactive created by user.
     * @param token
     * @param isSurveyInitialize
     */
    public void hitSurveyActiveApi(String token, boolean isSurveyInitialize) {

        apiManager.hitSurveyActiveApi(token).enqueue(new NetworkCallback<Widget>() {
            @Override
            public void onSuccess(Widget widget) {
                callbacks.onWidgetSuccess(widget, isSurveyInitialize);
            }

            @Override
            public void onFailure(FailureResponse failureResponse) {

            }

            @Override
            public void onError(Throwable t) {

            }
        });

    }


    /**
     * This function create a verified or anonymous contact user to save the user information at server.
     * @param token
     * @param isContactCreated
     */
    public void createContact(Application mContext, String token, boolean isContactCreated) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Constant.COOKIE_ID, getCookieId());
        hashMap.put(Constant.FIRST_SEEN, getFirstSeen());
        hashMap.put(Constant.REQUEST_TYPE, Constant.ANDROID);
        hashMap.put(Constant.LAST_SEEN, AppUtils.getInstance().getCurrentTime(Calendar.getInstance().getTimeInMillis(), Constant.DATE_FORMAT));
        hashMap.put(Constant.IP_ADDRESS, AppUtils.getInstance().getLocalIpAddress());

        if (!TextUtils.isEmpty(getContactId())) {
            hashMap.put(Constant.CONTACT_ID, getContactId());
        } else {
            if (!TextUtils.isEmpty(getExternalVisitorId())) {
                hashMap.put(Constant.EXTERNAL_VISITOR_ID, getExternalVisitorId());
            }
        }
        if (!TextUtils.isEmpty(getEmailId())) {
            hashMap.put(Constant.EMAIL_ID, getEmailId());
        }
        if (!TextUtils.isEmpty(getContactName())) {
            hashMap.put(Constant.CONTACT_NAME, getContactName());
        }

        if (!TextUtils.isEmpty(getMobileNo())) {
            hashMap.put(Constant.MOBILE_NO, getMobileNo());
        }

        if (!TextUtils.isEmpty(getUniqueId())) {
            hashMap.put(Constant.UNIQUE_ID, getUniqueId());
        }

        hashMap.put(Constant.UNIQUE_REF_CODE, token);
        hashMap.put(Constant.JOB_TYPE, "sdktd");
        hashMap.put(Constant.COMPANY_ID, DataManager.getInstance().getCompanyID());
        hashMap.put(Constant.CONTACT_DEVICE_OS, Constant.ANDROID);
        hashMap.put(Constant.CONTACT_DEVICE_NAME, Build.MODEL);
        hashMap.put(Constant.CONTACT_DEVICE_MODEL, Build.MODEL);
        hashMap.put(Constant.CONTACT_DEVICE_BRAND, Build.BRAND);
        hashMap.put(Constant.CONTACT_DEVICE_OS_VERSION, Build.VERSION.RELEASE);
        hashMap.put(Constant.CONTACT_DEVICE, AppUtils.getInstance().isTablet(mContext) ? "Tablet" : "Mobile");

        apiManager.hitCreateContactApi(hashMap).enqueue(new NetworkCallback<ContactResponse>() {
            @Override
            public void onSuccess(ContactResponse contactResponse) {
                if (contactResponse != null && contactResponse.getData() != null) {

                    if (contactResponse.getData().getContactInfo() != null) {
                        if (!TextUtils.isEmpty(contactResponse.getData().getContactInfo().getId())) {
                            saveContactId(contactResponse.getData().getContactInfo().getId());
                            callbacks.onContactCreationSuccess(isContactCreated);
                        }
                    } else if (contactResponse.getData().getEvd() != null) {
                        if (!TextUtils.isEmpty(contactResponse.getData().getEvd().getId())) {
                            saveExternalVisitorId(contactResponse.getData().getEvd().getId());
                            callbacks.onContactCreationSuccess(isContactCreated);
                        }
                    }
                }
            }

            @Override
            public void onFailure(FailureResponse failureResponse) {

            }

            @Override
            public void onError(Throwable t) {

            }
        });
    }

    public void createContactForDynamicAttribute(HashMap<String, Object> hashMapData, Application mContext, String token, boolean isContactCreated) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Constant.COOKIE_ID, getCookieId());
        hashMap.put(Constant.FIRST_SEEN, getFirstSeen());
        hashMap.put(Constant.REQUEST_TYPE, Constant.ANDROID);
        hashMap.put(Constant.LAST_SEEN, AppUtils.getInstance().getCurrentTime(Calendar.getInstance().getTimeInMillis(), Constant.DATE_FORMAT));
        hashMap.put(Constant.IP_ADDRESS, AppUtils.getInstance().getLocalIpAddress());

        if (!TextUtils.isEmpty(getContactId())) {
            hashMap.put(Constant.CONTACT_ID, getContactId());
        } else {
            if (!TextUtils.isEmpty(getExternalVisitorId())) {
                hashMap.put(Constant.EXTERNAL_VISITOR_ID, getExternalVisitorId());
            }
        }
        if (!TextUtils.isEmpty(getEmailId())) {
            hashMap.put(Constant.EMAIL_ID, getEmailId());
        }
        if (!TextUtils.isEmpty(getContactName())) {
            hashMap.put(Constant.CONTACT_NAME, getContactName());
        }

        if (!TextUtils.isEmpty(getMobileNo())) {
            hashMap.put(Constant.MOBILE_NO, getMobileNo());
        }

        if (!TextUtils.isEmpty(getUniqueId())) {
            hashMap.put(Constant.UNIQUE_ID, getUniqueId());
        }

        hashMap.put(Constant.UNIQUE_REF_CODE, token);
        hashMap.put(Constant.JOB_TYPE, "sdktd");
        hashMap.put(Constant.COMPANY_ID, DataManager.getInstance().getCompanyID());
        hashMap.put(Constant.CONTACT_DEVICE_OS, Constant.ANDROID);
        hashMap.put(Constant.CONTACT_DEVICE_NAME, Build.MODEL);
        hashMap.put(Constant.CONTACT_DEVICE_MODEL, Build.MODEL);
        hashMap.put(Constant.CONTACT_DEVICE_BRAND, Build.BRAND);
        hashMap.put(Constant.CONTACT_DEVICE_OS_VERSION, Build.VERSION.RELEASE);
        hashMap.put(Constant.CONTACT_DEVICE, AppUtils.getInstance().isTablet(mContext) ? "Tablet" : "Mobile");

        hashMapData.putAll(hashMap);
        apiManager.hitCreateContactApiDynamic(hashMapData).enqueue(new NetworkCallback<ContactResponse>() {
            @Override
            public void onSuccess(ContactResponse contactResponse) {
                if (contactResponse != null && contactResponse.getData() != null) {

                    if (contactResponse.getData().getContactInfo() != null) {
                        if (!TextUtils.isEmpty(contactResponse.getData().getContactInfo().getId())) {
                            saveContactId(contactResponse.getData().getContactInfo().getId());
                            callbacks.onContactCreationSuccess(isContactCreated);
                        }
                    } else if (contactResponse.getData().getEvd() != null) {
                        if (!TextUtils.isEmpty(contactResponse.getData().getEvd().getId())) {
                            saveExternalVisitorId(contactResponse.getData().getEvd().getId());
                            callbacks.onContactCreationSuccess(isContactCreated);
                        }
                    }
                }
            }

            @Override
            public void onFailure(FailureResponse failureResponse) {

            }

            @Override
            public void onError(Throwable t) {

            }
        });
    }


    /**
     * This function sends the event to the server when actions are performed by user
     * such as dismiss Event.
     * @param token
     */
    public void sendEventToServer(String token) {
        EventRequest eventRequest = new EventRequest();
        eventRequest.setSurveyRefCode(token);
        eventRequest.setIpAddress(AppUtils.getInstance().getLocalIpAddress());
        eventRequest.setDevice(Build.BRAND);
        eventRequest.setDeviceSerialNumber(AppUtils.getInstance().getDeviceSerial());
        eventRequest.setDeviceBrand(Build.BRAND);
        eventRequest.setDeviceModel(Build.MODEL);
        eventRequest.setDeviceName(Build.MODEL);
        eventRequest.setDeviceOS(Constant.ANDROID);
        eventRequest.setDeviceOSVersion(Build.VERSION.RELEASE);
        if (!TextUtils.isEmpty(getContactId())) {
            eventRequest.setContactId(getContactId());
        } else {
            if (!TextUtils.isEmpty(getExternalVisitorId())) {
                eventRequest.setExternalVisitorId(getExternalVisitorId());
            }
        }

        apiManager.sendEventToServer(eventRequest).enqueue(new NetworkCallback<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody responseBody) {

            }

            @Override
            public void onFailure(FailureResponse failureResponse) {

            }

            @Override
            public void onError(Throwable t) {

            }
        });
    }

    /**
     * Saved sessions are updated in this function.
     * @param token
     * @param sessionList
     */
    public void updateSessionToServer(String token, ArrayList<Sessions> sessionList) {
        UpdateSessionRequest sessionRequest = new UpdateSessionRequest();
        sessionRequest.setDeviceType(Constant.ANDROID);
        ArrayList<SessionLog> sessionLogList = new ArrayList<>();
        for (int i = 0; i < sessionList.size(); i++) {
            if (sessionList.get(i).getEndTime() != 0L) {
                SessionLog sessionLog = new SessionLog();
                String sessionStartTime = AppUtils.getInstance().getCurrentTime(sessionList.get(i).getStartTime(), Constant.DATE_FORMAT);
                String sessionEndTime = AppUtils.getInstance().getCurrentTime(sessionList.get(i).getEndTime(), Constant.DATE_FORMAT);
                sessionLog.setSessionStartedAt(sessionStartTime);
                sessionLog.setSessionClosedAt(sessionEndTime);
                sessionLog.setUniqueSessId(sessionList.get(i).getId());
                sessionLog.setCookieId(getCookieId());
                sessionLog.setIpAddress(AppUtils.getInstance().getLocalIpAddress());
                if(!TextUtils.isEmpty(getContactId())){
                    sessionLog.setContactId(getContactId());
                }else {
                    sessionLog.setAnonymousVisitorId(getExternalVisitorId());
                }
                sessionLogList.add(sessionLog);
            }
        }
        sessionRequest.setSessionLogs(sessionLogList);
        apiManager.updateSessionToServer(token, sessionRequest).enqueue(new NetworkCallback<SessionResponse>() {
            @Override
            public void onSuccess(SessionResponse sessionResponse) {
              if(sessionResponse != null && sessionResponse.getData() != null){
                 ArrayList<String> idList =  sessionResponse.getData().getSavedUniqueSessions();
                 if(idList != null && idList.size() > 0){
                     callbacks.onSessionUpdateSuccess(idList);
                 }
              }
            }

            @Override
            public void onFailure(FailureResponse failureResponse) {

            }

            @Override
            public void onError(Throwable t) {

            }
        });
    }


    public void setSessionEndTime(long sessionEndTime) {
        PreferenceManager.getInstance().putLong(Constant.SESSION_END_TIME, sessionEndTime);
    }

    public void setWidgetActivity(boolean isWidgetActive) {
        PreferenceManager.getInstance().putBoolean(Constant.IS_WIDGET_ACTIVE, isWidgetActive);
    }

    public void setCompanyId(String companyId) {
        PreferenceManager.getInstance().putString(Constant.COMPANY_ID, companyId);
    }

    public void saveFirstSeen() {
        if (TextUtils.isEmpty(getFirstSeen())) {
            long firstSeenTimeStamp = Calendar.getInstance().getTimeInMillis();
            String firstSeen = AppUtils.getInstance().getCurrentTime(firstSeenTimeStamp, "yyyy-MM-dd HH:mm:ss");
            PreferenceManager.getInstance().putString(Constant.USER_FIRST_SEEN, firstSeen);
        }
    }

    public void saveCookieId() {
        if (TextUtils.isEmpty(getCookieId())) {
            String cookieId = AppUtils.getInstance().getCookieId(24);
            PreferenceManager.getInstance().putString(Constant.COOKIE_ID, "ad-"+cookieId);
        }
    }


    public void saveContactId(String contactId) {
        PreferenceManager.getInstance().putString(Constant.CONTACT_ID, contactId);
    }


    public void saveExternalVisitorId(String evd) {
        PreferenceManager.getInstance().putString(Constant.EXTERNAL_VISITOR_ID, evd);
    }


    public void saveEmailId(String emailId) {
        PreferenceManager.getInstance().putString(Constant.EMAIL_ID, emailId);
    }


    public void saveMobileNo(String mobileNo) {
        PreferenceManager.getInstance().putString(Constant.MOBILE_NO, mobileNo);
    }


    public void saveUniqueId(String uniqueId) {
        PreferenceManager.getInstance().putString(Constant.UNIQUE_ID, uniqueId);
    }

    public void saveRegion(String zfRegion) {
        PreferenceManager.getInstance().putString(Constant.ZF_REGION, zfRegion);
    }

    public void saveContactName(String contactName) {
        PreferenceManager.getInstance().putString(Constant.CONTACT_NAME, contactName);
    }


    public boolean isWidgetActive() {
        return PreferenceManager.getInstance().getBoolean(Constant.IS_WIDGET_ACTIVE, false);
    }

    public String getCompanyID() {
        return PreferenceManager.getInstance().getString(Constant.COMPANY_ID, "");
    }
    public long getSessionEndTime() {
        return PreferenceManager.getInstance().getLong(Constant.SESSION_END_TIME);
    }

    public String getFirstSeen() {
        return PreferenceManager.getInstance().getString(Constant.USER_FIRST_SEEN, "");
    }

    public String getCookieId() {
        return PreferenceManager.getInstance().getString(Constant.COOKIE_ID, "");
    }


    public String getContactId() {
        return PreferenceManager.getInstance().getString(Constant.CONTACT_ID, "");
    }

    public String getExternalVisitorId() {
        return PreferenceManager.getInstance().getString(Constant.EXTERNAL_VISITOR_ID, "");
    }

    public String getEmailId() {
        return PreferenceManager.getInstance().getString(Constant.EMAIL_ID, "");
    }


    public String getMobileNo() {
        return PreferenceManager.getInstance().getString(Constant.MOBILE_NO, "");
    }


    public String getUniqueId() {
        return PreferenceManager.getInstance().getString(Constant.UNIQUE_ID, "");
    }

    public String getRegion() {
        return PreferenceManager.getInstance().getString(Constant.ZF_REGION, "");
    }

    public String getContactName() {
        return PreferenceManager.getInstance().getString(Constant.CONTACT_NAME, "");
    }


    public void clearPreference(){
        if(!TextUtils.isEmpty(getRegion())){
            zfRegion = getRegion();
        }
        PreferenceManager.getInstance().clearAllPrefs();
        saveRegion(zfRegion);
    }


}






