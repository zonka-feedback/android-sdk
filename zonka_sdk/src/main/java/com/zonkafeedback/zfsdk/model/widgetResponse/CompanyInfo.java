
package com.zonkafeedback.zfsdk.model.widgetResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyInfo {

    @SerializedName("countryId")
    @Expose
    private CountryId countryId;
    @SerializedName("timeZoneId")
    @Expose
    private TimeZoneId timeZoneId;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("isDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("surveyWhiteLabelDomainValid")
    @Expose
    private Boolean surveyWhiteLabelDomainValid;
    @SerializedName("surveyWhiteLabelDomain")
    @Expose
    private String surveyWhiteLabelDomain;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("pre_mongified_id")
    @Expose
    private Integer preMongifiedId;

    public CountryId getCountryId() {
        return countryId;
    }

    public void setCountryId(CountryId countryId) {
        this.countryId = countryId;
    }

    public TimeZoneId getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(TimeZoneId timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getSurveyWhiteLabelDomainValid() {
        return surveyWhiteLabelDomainValid;
    }

    public void setSurveyWhiteLabelDomainValid(Boolean surveyWhiteLabelDomainValid) {
        this.surveyWhiteLabelDomainValid = surveyWhiteLabelDomainValid;
    }

    public String getSurveyWhiteLabelDomain() {
        return surveyWhiteLabelDomain;
    }

    public void setSurveyWhiteLabelDomain(String surveyWhiteLabelDomain) {
        this.surveyWhiteLabelDomain = surveyWhiteLabelDomain;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPreMongifiedId() {
        return preMongifiedId;
    }

    public void setPreMongifiedId(Integer preMongifiedId) {
        this.preMongifiedId = preMongifiedId;
    }

}
