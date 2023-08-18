
package com.zonkafeedback.zfsdk.model.widgetResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistributionInfo {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("isDefault")
    @Expose
    private Boolean isDefault;
    @SerializedName("isDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("isWidgetActive")
    @Expose
    private Boolean isWidgetActive;
    @SerializedName("allowMultipleResponsesFromSameDevice")
    @Expose
    private Boolean allowMultipleResponsesFromSameDevice;
    @SerializedName("isWorkspaceBasedWidget")
    @Expose
    private Boolean isWorkspaceBasedWidget;
    @SerializedName("smsMessage")
    @Expose
    private String smsMessage;
    @SerializedName("emailMessage")
    @Expose
    private String emailMessage;
    @SerializedName("emailSubject")
    @Expose
    private String emailSubject;
    @SerializedName("emailBody")
    @Expose
    private String emailBody;
    @SerializedName("emailLogo")
    @Expose
    private String emailLogo;
    @SerializedName("emailHeading")
    @Expose
    private String emailHeading;
    @SerializedName("emailHeadingColor")
    @Expose
    private String emailHeadingColor;
    @SerializedName("emailButtonText")
    @Expose
    private String emailButtonText;
    @SerializedName("emailButtonColor")
    @Expose
    private String emailButtonColor;
    @SerializedName("emailButtonTextColor")
    @Expose
    private String emailButtonTextColor;
    @SerializedName("emailSignature")
    @Expose
    private String emailSignature;
    @SerializedName("embedField")
    @Expose
    private Boolean embedField;
    @SerializedName("embedFieldButtonGradient")
    @Expose
    private Boolean embedFieldButtonGradient;
    @SerializedName("displayEmailSmsTracking")
    @Expose
    private Boolean displayEmailSmsTracking;
    @SerializedName("endDate")
    @Expose
    private Object endDate;
    @SerializedName("customerEndDate")
    @Expose
    private Object customerEndDate;
    @SerializedName("startDate")
    @Expose
    private Object startDate;
    @SerializedName("customerStartDate")
    @Expose
    private Object customerStartDate;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("modifiedBy")
    @Expose
    private String modifiedBy;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("pre_mongified_id")
    @Expose
    private Integer preMongifiedId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("uniqueRefCode")
    @Expose
    private String uniqueRefCode;
    @SerializedName("surveyId")
    @Expose
    private String surveyId;
    @SerializedName("companyId")
    @Expose
    private String companyId;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("modifiedDate")
    @Expose
    private String modifiedDate;
    @SerializedName("embedSettings")
    @Expose
    private EmbedSettings embedSettings;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsWidgetActive() {
        return isWidgetActive;
    }

    public void setIsWidgetActive(Boolean isWidgetActive) {
        this.isWidgetActive = isWidgetActive;
    }

    public Boolean getAllowMultipleResponsesFromSameDevice() {
        return allowMultipleResponsesFromSameDevice;
    }

    public void setAllowMultipleResponsesFromSameDevice(Boolean allowMultipleResponsesFromSameDevice) {
        this.allowMultipleResponsesFromSameDevice = allowMultipleResponsesFromSameDevice;
    }

    public Boolean getIsWorkspaceBasedWidget() {
        return isWorkspaceBasedWidget;
    }

    public void setIsWorkspaceBasedWidget(Boolean isWorkspaceBasedWidget) {
        this.isWorkspaceBasedWidget = isWorkspaceBasedWidget;
    }

    public String getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(String smsMessage) {
        this.smsMessage = smsMessage;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getEmailLogo() {
        return emailLogo;
    }

    public void setEmailLogo(String emailLogo) {
        this.emailLogo = emailLogo;
    }

    public String getEmailHeading() {
        return emailHeading;
    }

    public void setEmailHeading(String emailHeading) {
        this.emailHeading = emailHeading;
    }

    public String getEmailHeadingColor() {
        return emailHeadingColor;
    }

    public void setEmailHeadingColor(String emailHeadingColor) {
        this.emailHeadingColor = emailHeadingColor;
    }

    public String getEmailButtonText() {
        return emailButtonText;
    }

    public void setEmailButtonText(String emailButtonText) {
        this.emailButtonText = emailButtonText;
    }

    public String getEmailButtonColor() {
        return emailButtonColor;
    }

    public void setEmailButtonColor(String emailButtonColor) {
        this.emailButtonColor = emailButtonColor;
    }

    public String getEmailButtonTextColor() {
        return emailButtonTextColor;
    }

    public void setEmailButtonTextColor(String emailButtonTextColor) {
        this.emailButtonTextColor = emailButtonTextColor;
    }

    public String getEmailSignature() {
        return emailSignature;
    }

    public void setEmailSignature(String emailSignature) {
        this.emailSignature = emailSignature;
    }

    public Boolean getEmbedField() {
        return embedField;
    }

    public void setEmbedField(Boolean embedField) {
        this.embedField = embedField;
    }

    public Boolean getEmbedFieldButtonGradient() {
        return embedFieldButtonGradient;
    }

    public void setEmbedFieldButtonGradient(Boolean embedFieldButtonGradient) {
        this.embedFieldButtonGradient = embedFieldButtonGradient;
    }

    public Boolean getDisplayEmailSmsTracking() {
        return displayEmailSmsTracking;
    }

    public void setDisplayEmailSmsTracking(Boolean displayEmailSmsTracking) {
        this.displayEmailSmsTracking = displayEmailSmsTracking;
    }

    public Object getEndDate() {
        return endDate;
    }

    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

    public Object getCustomerEndDate() {
        return customerEndDate;
    }

    public void setCustomerEndDate(Object customerEndDate) {
        this.customerEndDate = customerEndDate;
    }

    public Object getStartDate() {
        return startDate;
    }

    public void setStartDate(Object startDate) {
        this.startDate = startDate;
    }

    public Object getCustomerStartDate() {
        return customerStartDate;
    }

    public void setCustomerStartDate(Object customerStartDate) {
        this.customerStartDate = customerStartDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniqueRefCode() {
        return uniqueRefCode;
    }

    public void setUniqueRefCode(String uniqueRefCode) {
        this.uniqueRefCode = uniqueRefCode;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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

    public EmbedSettings getEmbedSettings() {
        return embedSettings;
    }

    public void setEmbedSettings(EmbedSettings embedSettings) {
        this.embedSettings = embedSettings;
    }

}
