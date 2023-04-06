package com.zonkafeedback.zfsdk;

import android.text.TextUtils;
import android.util.Log;


import java.io.Serializable;
import java.util.HashMap;

/**
 * This survey class is the Helper class for ZFSurvey to set and pass data choose by user.
 */
public final class Survey implements Serializable {
    private String baseUrl;
    private String surveyToken;
    private boolean deviceDetails = true;
    private HashMap<String, Object> hashMap;

    /**
     * @param surveyToken Survey token.
     * This Survey Token basically helps to create Contact and load a survey in Embed dialog.
     */
    public Survey(String surveyToken, String zfRegion) {
        if (TextUtils.isEmpty(surveyToken)) {
            Log.i(Constant.TAG,"Token should not be empty");
            return;
        }
        this.baseUrl = generateBaseUrl(surveyToken, zfRegion);
        this.surveyToken = surveyToken;
    }


    /**
     * This method calls when user wants to share the device related information.
     *
     * @param deviceDetails
     */
    public void sendDeviceDetails(boolean deviceDetails) {
        this.deviceDetails = deviceDetails;
    }


    public boolean getDeviceDetails() {
        return deviceDetails;
    }


    /**
     * This function creates the basic url to load an Embed survey.
     */
    public String getZfSurveyUrl() {
        String customVariableString = "?";
        return baseUrl + customVariableString;
    }

    public String getSurveyToken() {
        return surveyToken;
    }


    /**
     * Add custom params by name & value
     */
    public void sendCustomAttributes(HashMap<String, Object> hashMap) {
        this.hashMap = hashMap;
    }

    public HashMap<String, Object> getCustomAttributes() {
        return hashMap;
    }


    /**
     * This function generates the base url by appending survey token shared by user.
     *
     * @param surveyToken
     * @return
     */
    private String generateBaseUrl(CharSequence surveyToken, String zfRegion) {
          if (!TextUtils.isEmpty(zfRegion) && zfRegion.equalsIgnoreCase("EU")) {
                return Constant.HTTPS + "e" + Constant.URL + surveyToken;
            }

        return Constant.HTTPS + "us1" + Constant.URL + surveyToken;
    }

}
