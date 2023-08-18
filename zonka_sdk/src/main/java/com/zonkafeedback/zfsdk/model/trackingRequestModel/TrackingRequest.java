
package com.zonkafeedback.zfsdk.model.trackingRequestModel;

import java.io.Serializable;
import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrackingRequest implements Serializable, Parcelable
{

    @SerializedName("workSpaceId")
    @Expose
    private String workSpaceId;
    @SerializedName("companyId")
    @Expose
    private String companyId;
    @SerializedName("cookieId")
    @Expose
    private String cookieId;
    @SerializedName("sessCookieId")
    @Expose
    private String sessCookieId;
    @SerializedName("firstPageQStr")
    @Expose
    private String firstPageQStr;
    @SerializedName("firstSeen")
    @Expose
    private String firstSeen;
    @SerializedName("firstPage")
    @Expose
    private String firstPage;
    @SerializedName("pagesViewed")
    @Expose
    private List<String> pagesViewed;
    @SerializedName("pagesViewedLogs")
    @Expose
    private List<PagesViewedLog> pagesViewedLogs;
    @SerializedName("firstReferringSite")
    @Expose
    private String firstReferringSite;
    @SerializedName("firstUserAgent")
    @Expose
    private String firstUserAgent;
    @SerializedName("firstBrowserLanguage")
    @Expose
    private String firstBrowserLanguage;
    @SerializedName("firstDevice")
    @Expose
    private String firstDevice;
    @SerializedName("firstScreenSize")
    @Expose
    private String firstScreenSize;
    @SerializedName("lastSeen")
    @Expose
    private String lastSeen;
    @SerializedName("lastPage")
    @Expose
    private String lastPage;
    @SerializedName("lastReferringSite")
    @Expose
    private String lastReferringSite;
    @SerializedName("lastUserAgent")
    @Expose
    private String lastUserAgent;
    @SerializedName("lastDevice")
    @Expose
    private String lastDevice;
    @SerializedName("lastScreenSize")
    @Expose
    private String lastScreenSize;
    @SerializedName("lastBrowserLanguage")
    @Expose
    private String lastBrowserLanguage;
    @SerializedName("externalVisitorId")
    @Expose
    private String externalVisitorId;
    @SerializedName("contact_name")
    @Expose
    private String contactName;
    @SerializedName("contact_email")
    @Expose
    private String contactEmail;
    @SerializedName("contact_companyid")
    @Expose
    private String contactCompanyid;
    @SerializedName("contact_company_name")
    @Expose
    private String contactCompanyName;
    @SerializedName("contact_owner")
    @Expose
    private Boolean contactOwner;
    @SerializedName("contact_user_role")
    @Expose
    private String contactUserRole;
    @SerializedName("contact_subscription_plan")
    @Expose
    private String contactSubscriptionPlan;
    @SerializedName("contact_subscription_period")
    @Expose
    private String contactSubscriptionPeriod;
    @SerializedName("contactId")
    @Expose
    private String contactId;
    @SerializedName("dynamicList")
    @Expose
    private List<String> dynamicList;
    @SerializedName("lastWebWidgetShown")
    @Expose
    private String lastWebWidgetShown;
    @SerializedName("segmentCall")
    @Expose
    private Boolean segmentCall;
    public final static Creator<TrackingRequest> CREATOR = new Creator<TrackingRequest>() {


        public TrackingRequest createFromParcel(android.os.Parcel in) {
            return new TrackingRequest(in);
        }

        public TrackingRequest[] newArray(int size) {
            return (new TrackingRequest[size]);
        }

    }
    ;
    private final static long serialVersionUID = -7976172543925310460L;

    @SuppressWarnings({
        "unchecked"
    })
    protected TrackingRequest(android.os.Parcel in) {
        this.workSpaceId = ((String) in.readValue((String.class.getClassLoader())));
        this.companyId = ((String) in.readValue((String.class.getClassLoader())));
        this.cookieId = ((String) in.readValue((String.class.getClassLoader())));
        this.sessCookieId = ((String) in.readValue((String.class.getClassLoader())));
        this.firstPageQStr = ((String) in.readValue((String.class.getClassLoader())));
        this.firstSeen = ((String) in.readValue((String.class.getClassLoader())));
        this.firstPage = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.pagesViewed, (String.class.getClassLoader()));
        in.readList(this.pagesViewedLogs, (PagesViewedLog.class.getClassLoader()));
        this.firstReferringSite = ((String) in.readValue((String.class.getClassLoader())));
        this.firstUserAgent = ((String) in.readValue((String.class.getClassLoader())));
        this.firstBrowserLanguage = ((String) in.readValue((String.class.getClassLoader())));
        this.firstDevice = ((String) in.readValue((String.class.getClassLoader())));
        this.firstScreenSize = ((String) in.readValue((String.class.getClassLoader())));
        this.lastSeen = ((String) in.readValue((String.class.getClassLoader())));
        this.lastPage = ((String) in.readValue((String.class.getClassLoader())));
        this.lastReferringSite = ((String) in.readValue((String.class.getClassLoader())));
        this.lastUserAgent = ((String) in.readValue((String.class.getClassLoader())));
        this.lastDevice = ((String) in.readValue((String.class.getClassLoader())));
        this.lastScreenSize = ((String) in.readValue((String.class.getClassLoader())));
        this.lastBrowserLanguage = ((String) in.readValue((String.class.getClassLoader())));
        this.externalVisitorId = ((String) in.readValue((String.class.getClassLoader())));
        this.contactName = ((String) in.readValue((String.class.getClassLoader())));
        this.contactEmail = ((String) in.readValue((String.class.getClassLoader())));
        this.contactCompanyid = ((String) in.readValue((String.class.getClassLoader())));
        this.contactCompanyName = ((String) in.readValue((String.class.getClassLoader())));
        this.contactOwner = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.contactUserRole = ((String) in.readValue((String.class.getClassLoader())));
        this.contactSubscriptionPlan = ((String) in.readValue((String.class.getClassLoader())));
        this.contactSubscriptionPeriod = ((String) in.readValue((String.class.getClassLoader())));
        this.contactId = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.dynamicList, (String.class.getClassLoader()));
        this.lastWebWidgetShown = ((String) in.readValue((String.class.getClassLoader())));
        this.segmentCall = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public TrackingRequest() {
    }

    public String getWorkSpaceId() {
        return workSpaceId;
    }

    public void setWorkSpaceId(String workSpaceId) {
        this.workSpaceId = workSpaceId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCookieId() {
        return cookieId;
    }

    public void setCookieId(String cookieId) {
        this.cookieId = cookieId;
    }

    public String getSessCookieId() {
        return sessCookieId;
    }

    public void setSessCookieId(String sessCookieId) {
        this.sessCookieId = sessCookieId;
    }

    public String getFirstPageQStr() {
        return firstPageQStr;
    }

    public void setFirstPageQStr(String firstPageQStr) {
        this.firstPageQStr = firstPageQStr;
    }

    public String getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(String firstSeen) {
        this.firstSeen = firstSeen;
    }

    public String getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(String firstPage) {
        this.firstPage = firstPage;
    }

    public List<String> getPagesViewed() {
        return pagesViewed;
    }

    public void setPagesViewed(List<String> pagesViewed) {
        this.pagesViewed = pagesViewed;
    }

    public List<PagesViewedLog> getPagesViewedLogs() {
        return pagesViewedLogs;
    }

    public void setPagesViewedLogs(List<PagesViewedLog> pagesViewedLogs) {
        this.pagesViewedLogs = pagesViewedLogs;
    }

    public String getFirstReferringSite() {
        return firstReferringSite;
    }

    public void setFirstReferringSite(String firstReferringSite) {
        this.firstReferringSite = firstReferringSite;
    }

    public String getFirstUserAgent() {
        return firstUserAgent;
    }

    public void setFirstUserAgent(String firstUserAgent) {
        this.firstUserAgent = firstUserAgent;
    }

    public String getFirstBrowserLanguage() {
        return firstBrowserLanguage;
    }

    public void setFirstBrowserLanguage(String firstBrowserLanguage) {
        this.firstBrowserLanguage = firstBrowserLanguage;
    }

    public String getFirstDevice() {
        return firstDevice;
    }

    public void setFirstDevice(String firstDevice) {
        this.firstDevice = firstDevice;
    }

    public String getFirstScreenSize() {
        return firstScreenSize;
    }

    public void setFirstScreenSize(String firstScreenSize) {
        this.firstScreenSize = firstScreenSize;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getLastPage() {
        return lastPage;
    }

    public void setLastPage(String lastPage) {
        this.lastPage = lastPage;
    }

    public String getLastReferringSite() {
        return lastReferringSite;
    }

    public void setLastReferringSite(String lastReferringSite) {
        this.lastReferringSite = lastReferringSite;
    }

    public String getLastUserAgent() {
        return lastUserAgent;
    }

    public void setLastUserAgent(String lastUserAgent) {
        this.lastUserAgent = lastUserAgent;
    }

    public String getLastDevice() {
        return lastDevice;
    }

    public void setLastDevice(String lastDevice) {
        this.lastDevice = lastDevice;
    }

    public String getLastScreenSize() {
        return lastScreenSize;
    }

    public void setLastScreenSize(String lastScreenSize) {
        this.lastScreenSize = lastScreenSize;
    }

    public String getLastBrowserLanguage() {
        return lastBrowserLanguage;
    }

    public void setLastBrowserLanguage(String lastBrowserLanguage) {
        this.lastBrowserLanguage = lastBrowserLanguage;
    }

    public String getExternalVisitorId() {
        return externalVisitorId;
    }

    public void setExternalVisitorId(String externalVisitorId) {
        this.externalVisitorId = externalVisitorId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactCompanyid() {
        return contactCompanyid;
    }

    public void setContactCompanyid(String contactCompanyid) {
        this.contactCompanyid = contactCompanyid;
    }

    public String getContactCompanyName() {
        return contactCompanyName;
    }

    public void setContactCompanyName(String contactCompanyName) {
        this.contactCompanyName = contactCompanyName;
    }

    public Boolean getContactOwner() {
        return contactOwner;
    }

    public void setContactOwner(Boolean contactOwner) {
        this.contactOwner = contactOwner;
    }

    public String getContactUserRole() {
        return contactUserRole;
    }

    public void setContactUserRole(String contactUserRole) {
        this.contactUserRole = contactUserRole;
    }

    public String getContactSubscriptionPlan() {
        return contactSubscriptionPlan;
    }

    public void setContactSubscriptionPlan(String contactSubscriptionPlan) {
        this.contactSubscriptionPlan = contactSubscriptionPlan;
    }

    public String getContactSubscriptionPeriod() {
        return contactSubscriptionPeriod;
    }

    public void setContactSubscriptionPeriod(String contactSubscriptionPeriod) {
        this.contactSubscriptionPeriod = contactSubscriptionPeriod;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public List<String> getDynamicList() {
        return dynamicList;
    }

    public void setDynamicList(List<String> dynamicList) {
        this.dynamicList = dynamicList;
    }

    public String getLastWebWidgetShown() {
        return lastWebWidgetShown;
    }

    public void setLastWebWidgetShown(String lastWebWidgetShown) {
        this.lastWebWidgetShown = lastWebWidgetShown;
    }

    public Boolean getSegmentCall() {
        return segmentCall;
    }

    public void setSegmentCall(Boolean segmentCall) {
        this.segmentCall = segmentCall;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(workSpaceId);
        dest.writeValue(companyId);
        dest.writeValue(cookieId);
        dest.writeValue(sessCookieId);
        dest.writeValue(firstPageQStr);
        dest.writeValue(firstSeen);
        dest.writeValue(firstPage);
        dest.writeList(pagesViewed);
        dest.writeList(pagesViewedLogs);
        dest.writeValue(firstReferringSite);
        dest.writeValue(firstUserAgent);
        dest.writeValue(firstBrowserLanguage);
        dest.writeValue(firstDevice);
        dest.writeValue(firstScreenSize);
        dest.writeValue(lastSeen);
        dest.writeValue(lastPage);
        dest.writeValue(lastReferringSite);
        dest.writeValue(lastUserAgent);
        dest.writeValue(lastDevice);
        dest.writeValue(lastScreenSize);
        dest.writeValue(lastBrowserLanguage);
        dest.writeValue(externalVisitorId);
        dest.writeValue(contactName);
        dest.writeValue(contactEmail);
        dest.writeValue(contactCompanyid);
        dest.writeValue(contactCompanyName);
        dest.writeValue(contactOwner);
        dest.writeValue(contactUserRole);
        dest.writeValue(contactSubscriptionPlan);
        dest.writeValue(contactSubscriptionPeriod);
        dest.writeValue(contactId);
        dest.writeList(dynamicList);
        dest.writeValue(lastWebWidgetShown);
        dest.writeValue(segmentCall);
    }

    public int describeContents() {
        return  0;
    }

}
