
package com.zonkafeedback.zfsdk.model.contactResponse;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Evd {

    @SerializedName("firstSeen")
    @Expose
    private String firstSeen;
    @SerializedName("lastSeen")
    @Expose
    private String lastSeen;
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
    @SerializedName("surveysVisits")
    @Expose
    private List<Object> surveysVisits = null;
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
    @SerializedName("totalResponses")
    @Expose
    private Integer totalResponses;
    @SerializedName("lastResponseDateTime")
    @Expose
    private Object lastResponseDateTime;
    @SerializedName("source")
    @Expose
    private String source;
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
    @SerializedName("lists")
    @Expose
    private List<String> lists = null;
    @SerializedName("isDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("totalUncountedSession")
    @Expose
    private Integer totalUncountedSession;
    @SerializedName("lastSessionActiveAt")
    @Expose
    private Object lastSessionActiveAt;
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
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    public String getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(String firstSeen) {
        this.firstSeen = firstSeen;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
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

    public List<Object> getSurveysVisits() {
        return surveysVisits;
    }

    public void setSurveysVisits(List<Object> surveysVisits) {
        this.surveysVisits = surveysVisits;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public Integer getTotalUncountedSession() {
        return totalUncountedSession;
    }

    public void setTotalUncountedSession(Integer totalUncountedSession) {
        this.totalUncountedSession = totalUncountedSession;
    }

    public Object getLastSessionActiveAt() {
        return lastSessionActiveAt;
    }

    public void setLastSessionActiveAt(Object lastSessionActiveAt) {
        this.lastSessionActiveAt = lastSessionActiveAt;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
