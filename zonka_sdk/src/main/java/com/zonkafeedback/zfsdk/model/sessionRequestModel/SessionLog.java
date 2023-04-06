
package com.zonkafeedback.zfsdk.model.sessionRequestModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class SessionLog {

    @SerializedName("uniqueSessId")
    @Expose
    private String uniqueSessId;
    @SerializedName("anonymousVisitorId")
    @Expose
    private String anonymousVisitorId;
    @SerializedName("contactId")
    @Expose
    private String contactId;

    @SerializedName("cookieId")
    @Expose
    private String cookieId;
    @SerializedName("ipAddress")
    @Expose
    private String ipAddress;
    @SerializedName("sessionClosedAt")
    @Expose
    private String sessionClosedAt;
    @SerializedName("sessionStartedAt")
    @Expose
    private String sessionStartedAt;

    public String getUniqueSessId() {
        return uniqueSessId;
    }

    public void setUniqueSessId(String uniqueSessId) {
        this.uniqueSessId = uniqueSessId;
    }

    public String getAnonymousVisitorId() {
        return anonymousVisitorId;
    }

    public void setAnonymousVisitorId(String anonymousVisitorId) {
        this.anonymousVisitorId = anonymousVisitorId;
    }

    public String getCookieId() {
        return cookieId;
    }

    public void setCookieId(String cookieId) {
        this.cookieId = cookieId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSessionClosedAt() {
        return sessionClosedAt;
    }

    public void setSessionClosedAt(String sessionClosedAt) {
        this.sessionClosedAt = sessionClosedAt;
    }

    public String getSessionStartedAt() {
        return sessionStartedAt;
    }

    public void setSessionStartedAt(String sessionStartedAt) {
        this.sessionStartedAt = sessionStartedAt;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
}
