
package com.zonkafeedback.zfsdk.model.contactResponse;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactInfo {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("emailAddress")
    @Expose
    private String emailAddress;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("uniqueId")
    @Expose
    private String uniqueId;
    @SerializedName("lists")
    @Expose
    private List<String> lists = null;
    @SerializedName("isDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("unsubscribeEmail")
    @Expose
    private Boolean unsubscribeEmail;
    @SerializedName("unsubscribeSMS")
    @Expose
    private Boolean unsubscribeSMS;
    @SerializedName("lastSmsSurveySentDatetime")
    @Expose
    private Object lastSmsSurveySentDatetime;
    @SerializedName("lastEmailSurveySentDatetime")
    @Expose
    private Object lastEmailSurveySentDatetime;
    @SerializedName("createdBy")
    @Expose
    private Object createdBy;
    @SerializedName("modifiedBy")
    @Expose
    private Object modifiedBy;
    @SerializedName("totalResponses")
    @Expose
    private Integer totalResponses;
    @SerializedName("lastResponseDateTime")
    @Expose
    private Object lastResponseDateTime;
    @SerializedName("bounced")
    @Expose
    private Boolean bounced;
    @SerializedName("surveys")
    @Expose
    private List<Object> surveys = null;
    @SerializedName("locations")
    @Expose
    private List<Object> locations = null;
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes = null;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("numTasks")
    @Expose
    private Integer numTasks;
    @SerializedName("numPendingTasks")
    @Expose
    private Integer numPendingTasks;
    @SerializedName("numNotes")
    @Expose
    private Integer numNotes;
    @SerializedName("hasNote")
    @Expose
    private Boolean hasNote;
    @SerializedName("thirdpartySingupDate")
    @Expose
    private Object thirdpartySingupDate;
    @SerializedName("thirdpartyCreatedDate")
    @Expose
    private Object thirdpartyCreatedDate;
    @SerializedName("thirdpartyUpdatedDate")
    @Expose
    private Object thirdpartyUpdatedDate;
    @SerializedName("firstSeen")
    @Expose
    private Object firstSeen;
    @SerializedName("lastSeen")
    @Expose
    private Object lastSeen;
    @SerializedName("firstPage")
    @Expose
    private Object firstPage;
    @SerializedName("lastPage")
    @Expose
    private String lastPage;
    @SerializedName("lastWebWidgetShown")
    @Expose
    private Object lastWebWidgetShown;
    @SerializedName("lastSurveyViewedId")
    @Expose
    private Object lastSurveyViewedId;
    @SerializedName("lastSurveyViewedDate")
    @Expose
    private Object lastSurveyViewedDate;
    @SerializedName("sessionCounts")
    @Expose
    private Integer sessionCounts;
    @SerializedName("webSessionCounts")
    @Expose
    private Integer webSessionCounts;
    @SerializedName("androidSessionCounts")
    @Expose
    private Integer androidSessionCounts;
    @SerializedName("iosSessionCounts")
    @Expose
    private Integer iosSessionCounts;
    @SerializedName("mauNextCountAfterDate")
    @Expose
    private Object mauNextCountAfterDate;
    @SerializedName("pagesViewedCount")
    @Expose
    private Integer pagesViewedCount;
    @SerializedName("contactSource")
    @Expose
    private String contactSource;
    @SerializedName("utm_term")
    @Expose
    private String utmTerm;
    @SerializedName("utm_campaign")
    @Expose
    private String utmCampaign;
    @SerializedName("utm_medium")
    @Expose
    private String utmMedium;
    @SerializedName("utm_source")
    @Expose
    private String utmSource;
    @SerializedName("utm_content")
    @Expose
    private String utmContent;
    @SerializedName("firstReferringSite")
    @Expose
    private String firstReferringSite;
    @SerializedName("lastReferringSite")
    @Expose
    private String lastReferringSite;
    @SerializedName("languageCode")
    @Expose
    private Object languageCode;
    @SerializedName("surveysVisits")
    @Expose
    private List<Object> surveysVisits = null;
    @SerializedName("lastSessionActiveAt")
    @Expose
    private Object lastSessionActiveAt;
    @SerializedName("historyImportedFromAnonymous")
    @Expose
    private Boolean historyImportedFromAnonymous;
    @SerializedName("firstSeenOnIOS")
    @Expose
    private Object firstSeenOnIOS;
    @SerializedName("firstSeenOnAndroid")
    @Expose
    private Object firstSeenOnAndroid;
    @SerializedName("lastSeenOnIOS")
    @Expose
    private Object lastSeenOnIOS;
    @SerializedName("lastSeenOnAndroid")
    @Expose
    private Object lastSeenOnAndroid;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("companyId")
    @Expose
    private String companyId;
    @SerializedName("cookieId")
    @Expose
    private String cookieId;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("modifiedDate")
    @Expose
    private String modifiedDate;
    @SerializedName("pre_mongified_id")
    @Expose
    private Integer preMongifiedId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getUnsubscribeEmail() {
        return unsubscribeEmail;
    }

    public void setUnsubscribeEmail(Boolean unsubscribeEmail) {
        this.unsubscribeEmail = unsubscribeEmail;
    }

    public Boolean getUnsubscribeSMS() {
        return unsubscribeSMS;
    }

    public void setUnsubscribeSMS(Boolean unsubscribeSMS) {
        this.unsubscribeSMS = unsubscribeSMS;
    }

    public Object getLastSmsSurveySentDatetime() {
        return lastSmsSurveySentDatetime;
    }

    public void setLastSmsSurveySentDatetime(Object lastSmsSurveySentDatetime) {
        this.lastSmsSurveySentDatetime = lastSmsSurveySentDatetime;
    }

    public Object getLastEmailSurveySentDatetime() {
        return lastEmailSurveySentDatetime;
    }

    public void setLastEmailSurveySentDatetime(Object lastEmailSurveySentDatetime) {
        this.lastEmailSurveySentDatetime = lastEmailSurveySentDatetime;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public Object getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Object modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Integer getTotalResponses() {
        return totalResponses;
    }

    public void setTotalResponses(Integer totalResponses) {
        this.totalResponses = totalResponses;
    }

    public Object getLastResponseDateTime() {
        return lastResponseDateTime;
    }

    public void setLastResponseDateTime(Object lastResponseDateTime) {
        this.lastResponseDateTime = lastResponseDateTime;
    }

    public Boolean getBounced() {
        return bounced;
    }

    public void setBounced(Boolean bounced) {
        this.bounced = bounced;
    }

    public List<Object> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Object> surveys) {
        this.surveys = surveys;
    }

    public List<Object> getLocations() {
        return locations;
    }

    public void setLocations(List<Object> locations) {
        this.locations = locations;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getNumTasks() {
        return numTasks;
    }

    public void setNumTasks(Integer numTasks) {
        this.numTasks = numTasks;
    }

    public Integer getNumPendingTasks() {
        return numPendingTasks;
    }

    public void setNumPendingTasks(Integer numPendingTasks) {
        this.numPendingTasks = numPendingTasks;
    }

    public Integer getNumNotes() {
        return numNotes;
    }

    public void setNumNotes(Integer numNotes) {
        this.numNotes = numNotes;
    }

    public Boolean getHasNote() {
        return hasNote;
    }

    public void setHasNote(Boolean hasNote) {
        this.hasNote = hasNote;
    }

    public Object getThirdpartySingupDate() {
        return thirdpartySingupDate;
    }

    public void setThirdpartySingupDate(Object thirdpartySingupDate) {
        this.thirdpartySingupDate = thirdpartySingupDate;
    }

    public Object getThirdpartyCreatedDate() {
        return thirdpartyCreatedDate;
    }

    public void setThirdpartyCreatedDate(Object thirdpartyCreatedDate) {
        this.thirdpartyCreatedDate = thirdpartyCreatedDate;
    }

    public Object getThirdpartyUpdatedDate() {
        return thirdpartyUpdatedDate;
    }

    public void setThirdpartyUpdatedDate(Object thirdpartyUpdatedDate) {
        this.thirdpartyUpdatedDate = thirdpartyUpdatedDate;
    }

    public Object getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(Object firstSeen) {
        this.firstSeen = firstSeen;
    }

    public Object getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Object lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Object getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Object firstPage) {
        this.firstPage = firstPage;
    }

    public String getLastPage() {
        return lastPage;
    }

    public void setLastPage(String lastPage) {
        this.lastPage = lastPage;
    }

    public Object getLastWebWidgetShown() {
        return lastWebWidgetShown;
    }

    public void setLastWebWidgetShown(Object lastWebWidgetShown) {
        this.lastWebWidgetShown = lastWebWidgetShown;
    }

    public Object getLastSurveyViewedId() {
        return lastSurveyViewedId;
    }

    public void setLastSurveyViewedId(Object lastSurveyViewedId) {
        this.lastSurveyViewedId = lastSurveyViewedId;
    }

    public Object getLastSurveyViewedDate() {
        return lastSurveyViewedDate;
    }

    public void setLastSurveyViewedDate(Object lastSurveyViewedDate) {
        this.lastSurveyViewedDate = lastSurveyViewedDate;
    }

    public Integer getSessionCounts() {
        return sessionCounts;
    }

    public void setSessionCounts(Integer sessionCounts) {
        this.sessionCounts = sessionCounts;
    }

    public Integer getWebSessionCounts() {
        return webSessionCounts;
    }

    public void setWebSessionCounts(Integer webSessionCounts) {
        this.webSessionCounts = webSessionCounts;
    }

    public Integer getAndroidSessionCounts() {
        return androidSessionCounts;
    }

    public void setAndroidSessionCounts(Integer androidSessionCounts) {
        this.androidSessionCounts = androidSessionCounts;
    }

    public Integer getIosSessionCounts() {
        return iosSessionCounts;
    }

    public void setIosSessionCounts(Integer iosSessionCounts) {
        this.iosSessionCounts = iosSessionCounts;
    }

    public Object getMauNextCountAfterDate() {
        return mauNextCountAfterDate;
    }

    public void setMauNextCountAfterDate(Object mauNextCountAfterDate) {
        this.mauNextCountAfterDate = mauNextCountAfterDate;
    }

    public Integer getPagesViewedCount() {
        return pagesViewedCount;
    }

    public void setPagesViewedCount(Integer pagesViewedCount) {
        this.pagesViewedCount = pagesViewedCount;
    }

    public String getContactSource() {
        return contactSource;
    }

    public void setContactSource(String contactSource) {
        this.contactSource = contactSource;
    }

    public String getUtmTerm() {
        return utmTerm;
    }

    public void setUtmTerm(String utmTerm) {
        this.utmTerm = utmTerm;
    }

    public String getUtmCampaign() {
        return utmCampaign;
    }

    public void setUtmCampaign(String utmCampaign) {
        this.utmCampaign = utmCampaign;
    }

    public String getUtmMedium() {
        return utmMedium;
    }

    public void setUtmMedium(String utmMedium) {
        this.utmMedium = utmMedium;
    }

    public String getUtmSource() {
        return utmSource;
    }

    public void setUtmSource(String utmSource) {
        this.utmSource = utmSource;
    }

    public String getUtmContent() {
        return utmContent;
    }

    public void setUtmContent(String utmContent) {
        this.utmContent = utmContent;
    }

    public String getFirstReferringSite() {
        return firstReferringSite;
    }

    public void setFirstReferringSite(String firstReferringSite) {
        this.firstReferringSite = firstReferringSite;
    }

    public String getLastReferringSite() {
        return lastReferringSite;
    }

    public void setLastReferringSite(String lastReferringSite) {
        this.lastReferringSite = lastReferringSite;
    }

    public Object getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(Object languageCode) {
        this.languageCode = languageCode;
    }

    public List<Object> getSurveysVisits() {
        return surveysVisits;
    }

    public void setSurveysVisits(List<Object> surveysVisits) {
        this.surveysVisits = surveysVisits;
    }

    public Object getLastSessionActiveAt() {
        return lastSessionActiveAt;
    }

    public void setLastSessionActiveAt(Object lastSessionActiveAt) {
        this.lastSessionActiveAt = lastSessionActiveAt;
    }

    public Boolean getHistoryImportedFromAnonymous() {
        return historyImportedFromAnonymous;
    }

    public void setHistoryImportedFromAnonymous(Boolean historyImportedFromAnonymous) {
        this.historyImportedFromAnonymous = historyImportedFromAnonymous;
    }

    public Object getFirstSeenOnIOS() {
        return firstSeenOnIOS;
    }

    public void setFirstSeenOnIOS(Object firstSeenOnIOS) {
        this.firstSeenOnIOS = firstSeenOnIOS;
    }

    public Object getFirstSeenOnAndroid() {
        return firstSeenOnAndroid;
    }

    public void setFirstSeenOnAndroid(Object firstSeenOnAndroid) {
        this.firstSeenOnAndroid = firstSeenOnAndroid;
    }

    public Object getLastSeenOnIOS() {
        return lastSeenOnIOS;
    }

    public void setLastSeenOnIOS(Object lastSeenOnIOS) {
        this.lastSeenOnIOS = lastSeenOnIOS;
    }

    public Object getLastSeenOnAndroid() {
        return lastSeenOnAndroid;
    }

    public void setLastSeenOnAndroid(Object lastSeenOnAndroid) {
        this.lastSeenOnAndroid = lastSeenOnAndroid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getPreMongifiedId() {
        return preMongifiedId;
    }

    public void setPreMongifiedId(Integer preMongifiedId) {
        this.preMongifiedId = preMongifiedId;
    }

}
