
package com.zonkafeedback.zfsdk.model.eventModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventRequest {

    @SerializedName("ipAddress")
    @Expose
    private String ipAddress;
    @SerializedName("surveyRefCode")
    @Expose
    private String surveyRefCode;
    @SerializedName("externalVisitorId")
    @Expose
    private String externalVisitorId;
    @SerializedName("contactId")
    @Expose
    private String contactId;
    @SerializedName("device")
    @Expose
    private String device;
    @SerializedName("deviceOS")
    @Expose
    private String deviceOS;
    @SerializedName("deviceOSVersion")
    @Expose
    private String deviceOSVersion;
    @SerializedName("deviceSerialNumber")
    @Expose
    private String deviceSerialNumber;
    @SerializedName("deviceName")
    @Expose
    private String deviceName;
    @SerializedName("deviceModel")
    @Expose
    private String deviceModel;
    @SerializedName("deviceBrand")
    @Expose
    private String deviceBrand;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSurveyRefCode() {
        return surveyRefCode;
    }

    public void setSurveyRefCode(String surveyRefCode) {
        this.surveyRefCode = surveyRefCode;
    }

    public String getExternalVisitorId() {
        return externalVisitorId;
    }

    public void setExternalVisitorId(String externalVisitorId) {
        this.externalVisitorId = externalVisitorId;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDeviceOS() {
        return deviceOS;
    }

    public void setDeviceOS(String deviceOS) {
        this.deviceOS = deviceOS;
    }

    public String getDeviceOSVersion() {
        return deviceOSVersion;
    }

    public void setDeviceOSVersion(String deviceOSVersion) {
        this.deviceOSVersion = deviceOSVersion;
    }

    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
}
