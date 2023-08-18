package com.zonkafeedback.zfsdk;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import com.zonkafeedback.zfsdk.database.SessionCallbacks;
import com.zonkafeedback.zfsdk.interfaces.ApiResponseCallbacks;
import com.zonkafeedback.zfsdk.model.contactResponse.ContactResponse;
import com.zonkafeedback.zfsdk.model.widgetResponse.Data;
import com.zonkafeedback.zfsdk.model.widgetResponse.EmbedSettings;
import com.zonkafeedback.zfsdk.model.widgetResponse.Widget;
import com.zonkafeedback.zfsdk.retrofit.DataManager;
import com.zonkafeedback.zfsdk.utils.AppUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * ZFSurvey helper class.
 */
public final class ZFSurvey implements ApiResponseCallbacks {

    private static Survey survey;
    private Application mContext;
    private Activity contexts;
    private static volatile ZFSurvey zfSurvey;
    private String customVariableString = "";
    private String url = "";
    private SessionCallbacks sessionCallbacks;
    private ZFSurveyDialog zfSurveyDialog;
    private boolean processEmbedSurvey = true;


    public static void init(Application context, String token, String zfRegion) {
        if (zfSurvey == null) {
            synchronized (ZFSurvey.class) {
                if (zfSurvey == null) {
                    zfSurvey = new ZFSurvey();
                    initializeSDK(context, token, zfRegion);

                }
            }
        }
    }


    public static ZFSurvey getInstance() {

        if (zfSurvey == null) {
            throw new IllegalStateException("Must call init() before getInstance()");
        }
        return zfSurvey;
    }


    /**
     * Build a ZFSurvey object. By using this object you will be able to start a
     * Embed Survey dialog
     */
    private static void initializeSDK(Application context, String token, String zfRegion) {
        survey = new Survey(token, zfRegion);
        DataManager dataManager = DataManager.init(context, token);
        DataManager.getInstance().saveRegion(zfRegion);
        DataManager.getInstance().saveFirstSeen();
        DataManager.getInstance().saveCookieId();
        dataManager.initApiManager();
        getInstance().initializeZFData(context);
    }

    /**
     * Function used to initialize the ZFSurvey dependent objects.
     *
     * @param context
     */
    private void initializeZFData(Application context) {

        DataManager.getInstance().setApiCallbacks(this);
        mContext = context;
        getZfSurveyUrl();

        if (AppUtils.getInstance().isNetworkConnected(mContext)) {
            DataManager.getInstance().hitSurveyActiveApi(survey.getSurveyToken(), false);
        }
        sessionCallbacks = new SessionCallbacks(context, survey.getSurveyToken());
    }


    /**
     * This method is used to set device related details
     *
     * @param deviceDetails
     */
    public ZFSurvey sendDeviceDetails(boolean deviceDetails) {
        survey.sendDeviceDetails(deviceDetails);

        return this;
    }


    /**
     * This function creates the final url to load an Embed Survey.
     */
    private void getZfSurveyUrl() {
        url = survey.getZfSurveyUrl();
        customVariableString = "";
        if (survey.getCustomAttributes() != null && survey.getCustomAttributes().size() > 0) {
            addCustomParam(survey.getCustomAttributes());
            url = url + customVariableString;
        }

        if (!TextUtils.isEmpty(DataManager.getInstance().getCookieId())) {
            customVariableString = "";
            url = url + "cookieId" + "=" + DataManager.getInstance().getCookieId() + "&";
        }

        if (!TextUtils.isEmpty(DataManager.getInstance().getExternalVisitorId())) {
            customVariableString = "";
            url = url + "externalVisitorId" + "=" + DataManager.getInstance().getExternalVisitorId() + "&";
        }

        if (!TextUtils.isEmpty(DataManager.getInstance().getContactId())) {
            customVariableString = "";
            url = url + "contactId" + "=" + DataManager.getInstance().getContactId() + "&";
        }

        if (survey.getDeviceDetails()) {
            customVariableString = "";
            addCustomParam(AppUtils.getInstance().getHiddenVariables(mContext));
            url = url + customVariableString;
        }
    }


    /**
     * Add custom params by name & value
     *
     * @return Returns the same ZFSurvey object, for chaining
     * multiple calls into a single statement.
     */
    private void addCustomParam(HashMap<String, Object> hashMap) {
        for (Map.Entry<String, Object> set :
                hashMap.entrySet()) {
            customVariableString += set.getKey() + "=" + set.getValue() + "&";
        }
        userInfo(hashMap);
    }


    /**
     * This method will help user to pass user related details such as Email, user name etc.
     *
     * @param hashMap
     * @return
     */
    public ZFSurvey sendCustomAttributes(HashMap<String, Object> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            survey.sendCustomAttributes(hashMap);
        }
        return this;
    }


    /**
     * By calling this function user can load a survey in Embed dialog.
     */
    public void startSurvey(Activity context) {
        this.contexts = context;
        if (zfSurvey != null) {
            if (AppUtils.getInstance().isNetworkConnected(mContext)) {
                getZfSurveyUrl();
                if (TextUtils.isEmpty(DataManager.getInstance().getContactId())) {
                    if (TextUtils.isEmpty(DataManager.getInstance().getExternalVisitorId())) {
                        DataManager.getInstance().createContact(mContext,survey.getSurveyToken(), false);
                    } else {
                        DataManager.getInstance().hitSurveyActiveApi(survey.getSurveyToken(), true);
                    }
                } else {
                    DataManager.getInstance().hitSurveyActiveApi(survey.getSurveyToken(), true);
                }
            } else {
                return;
            }

            if (DataManager.getInstance().isWidgetActive()) {
                boolean segmentAllowed = checkSegmenting();
                if (segmentAllowed) {
                    zfSurveyDialog = new ZFSurveyDialog(context, url, () -> {
                        if (AppUtils.getInstance().isNetworkConnected(mContext)) {
                        }
                        if (zfSurveyDialog != null) {
                            zfSurveyDialog = null;
                        }
                    });
                    zfSurveyDialog.show();
                }
            }
        }
    }

    private boolean checkSegmenting() {

        Set<String> includedListSet = DataManager.getInstance().getIncludedList();
        ArrayList<String> includedList = new ArrayList<>();
        if(includedListSet!=null) {
            includedList.addAll(includedListSet);
            /*Clear the data of the list so that when API call is being made the next time,
            the data does not get added on in the previous list.*/
            DataManager.getInstance().getIncludedList().clear();
        }


        Set<String> excludedListSet = DataManager.getInstance().getExcludedList();
        ArrayList<String> excludedList = new ArrayList<>();
        if(excludedListSet!=null) {
            excludedList.addAll(excludedListSet);
            /*Clear the data of the list so that when API call is being made the next time,
            the data does not get added on in the previous list.*/
            DataManager.getInstance().getExcludedList().clear();
        }

        Set<String> contactListSet = DataManager.getInstance().getContactList();
        ArrayList<String> contactResponseList = new ArrayList<>();
        if (contactListSet!=null) {
            contactResponseList.addAll(contactListSet);
        }

        Set<String> evdListSet = DataManager.getInstance().getEvdList();
        ArrayList<String> evdResponseList = new ArrayList<>();
        if (evdListSet!=null) {
            evdResponseList.addAll(evdListSet);
        }

        Log.d("ContactListNew:", contactResponseList.toString());
        Log.d("ExcludedList:", excludedList.toString());
        Log.d("IncludedList:", includedList.toString());

        // check the include segments
        //includeType.equalsIgnoreCase("any")->condition removed from here
        if((!includedList.isEmpty()) && includedList.size() > 0){
            processEmbedSurvey = false;
            // now we have inclusion of the segments user only
            if((!contactResponseList.isEmpty()) && contactResponseList.size()>0){
                for (int i=0; i<contactResponseList.size(); i++) {
                    String segmentInContact = contactResponseList.get(i);

                    if(includedList.contains(segmentInContact)){
                        processEmbedSurvey = true;
                        break;
                    }
                }
            }
            //For anonymous users
            else if((!evdResponseList.isEmpty()) && evdResponseList.size()>0){
                for (int i=0; i<evdResponseList.size(); i++) {
                    String segmentInContact = evdResponseList.get(i);

                    if(includedList.contains(segmentInContact)){
                        processEmbedSurvey = true;
                        break;
                    }
                }
            }
        }

        // check exclude segments
        //excludeType.equalsIgnoreCase("any")->condition removed from here
        if((!excludedList.isEmpty()) && excludedList.size() > 0){
            // now we have inclusion of the segments user only
            if((!contactResponseList.isEmpty()) && contactResponseList.size()>0){
                for (int i=0; i<contactResponseList.size(); i++) {
                    String segmentInContact = contactResponseList.get(i);

                    if(excludedList.contains(segmentInContact)){
                        processEmbedSurvey = false;
                        break;
                    }
                }
            }
            //For anonymous users
            else if((!evdResponseList.isEmpty()) && evdResponseList.size()>0){
                for (int i=0; i<evdResponseList.size(); i++) {
                    String segmentInContact = evdResponseList.get(i);

                    if(excludedList.contains(segmentInContact)){
                        processEmbedSurvey = false;
                        break;
                    }
                }
            }
        }
        return processEmbedSurvey;
    }

    @Override
    public void onWidgetSuccess(Widget widget, boolean isSurveyInitialize) {
        DataManager.getInstance().setWidgetActivity(widget.getData().getDistributionInfo().getIsWidgetActive());
        DataManager.getInstance().setCompanyId(widget.getData().getDistributionInfo().getCompanyId());
        if (widget.getData().getDistributionInfo().getIsWidgetActive()) {

            if (zfSurveyDialog == null && isSurveyInitialize) {
                boolean segmentAllowed = checkSegmenting();
                if (segmentAllowed) {
                zfSurveyDialog = new ZFSurveyDialog(contexts, url, () -> {
                    if (AppUtils.getInstance().isNetworkConnected(mContext)) {
                    }
                    if (zfSurveyDialog != null) {
                        zfSurveyDialog = null;
                    }
                });
                zfSurveyDialog.show();
              }
            }
        } else {
            if (zfSurveyDialog != null) {
                zfSurveyDialog.dismiss();
            }
        }
    }

    @Override
    public void onSessionUpdateSuccess(ArrayList<String> idList) {
        sessionCallbacks.onSessionSave(idList);
    }


    @Override
    public void onContactCreationSuccess(boolean isContactCreated) {
        if (!isContactCreated) {
            startSurvey(contexts);
        }
    }


    /**
     * This function is used to get Email id, Mobile Number and Unique Id from the user to make an
     * anonymous user to verified contact user.
     *
     * @param hashMap
     * @return
     */
    public ZFSurvey userInfo(HashMap<String, Object> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Object> set : hashMap.entrySet()) {
                if (!TextUtils.isEmpty(set.getKey()) && set.getKey().equals(Constant.EMAIL_ID)) {
                    if (!TextUtils.isEmpty(set.getValue().toString()))
                        DataManager.getInstance().saveEmailId(set.getValue().toString());
                }
                if (!TextUtils.isEmpty(set.getKey()) && set.getKey().equals(Constant.MOBILE_NO)) {
                    if (!TextUtils.isEmpty(set.getValue().toString()))
                        DataManager.getInstance().saveMobileNo(set.getValue().toString());
                }
                if (!TextUtils.isEmpty(set.getKey()) && set.getKey().equals(Constant.UNIQUE_ID)) {
                    if (!TextUtils.isEmpty(set.getValue().toString()))
                        DataManager.getInstance().saveUniqueId(set.getValue().toString());
                }
                if (!TextUtils.isEmpty(set.getKey()) && set.getKey().equals(Constant.CONTACT_NAME)) {
                    if (!TextUtils.isEmpty(set.getValue().toString()))
                        DataManager.getInstance().saveContactName(set.getValue().toString());
                }
            }
        }
        DataManager.getInstance().createContactForDynamicAttribute(hashMap, mContext, survey.getSurveyToken(), true);
        return this;
    }

    /**
     * This function clear all the data from app preference.
     */
    public  void clear() {
        DataManager.getInstance().clearPreference();

        Log.d(Constant.TAG,DataManager.getInstance().getContactName());
        Log.d(Constant.TAG,DataManager.getInstance().getContactId());
        Log.d(Constant.TAG,DataManager.getInstance().getEmailId());
        Log.d(Constant.TAG,DataManager.getInstance().getExternalVisitorId());
        Log.d(Constant.TAG,DataManager.getInstance().getFirstSeen());
        Log.d(Constant.TAG,DataManager.getInstance().getEmailId());
        Log.d(Constant.TAG,DataManager.getInstance().getUniqueId());
        Log.d(Constant.TAG,DataManager.getInstance().getMobileNo());
        Log.d(Constant.TAG,DataManager.getInstance().getCookieId());
        Log.d(Constant.TAG,""+DataManager.getInstance().getExcludeType());
        Log.d(Constant.TAG,""+DataManager.getInstance().getIncludeType());
        Log.d(Constant.TAG,""+DataManager.getInstance().getExcludedList());
        Log.d(Constant.TAG,""+DataManager.getInstance().getIncludedList());
        Log.d(Constant.TAG,""+DataManager.getInstance().getContactList());

        DataManager.getInstance().saveFirstSeen();
        DataManager.getInstance().saveCookieId();
        /*initializeZFData(mContext);*/
    }
}
