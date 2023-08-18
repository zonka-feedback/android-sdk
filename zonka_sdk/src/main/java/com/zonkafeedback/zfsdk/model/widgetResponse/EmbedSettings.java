
package com.zonkafeedback.zfsdk.model.widgetResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmbedSettings {

    @SerializedName("embedType")
    @Expose
    private String embedType;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("button_text_color")
    @Expose
    private String buttonTextColor;
    @SerializedName("button_bg_color")
    @Expose
    private String buttonBgColor;
    @SerializedName("button_position")
    @Expose
    private String buttonPosition;
    @SerializedName("variant")
    @Expose
    private String variant;
    @SerializedName("button_text")
    @Expose
    private String buttonText;
    @SerializedName("trigger")
    @Expose
    private Trigger trigger;
    @SerializedName("devices")
    @Expose
    private Devices devices;
    @SerializedName("appearance")
    @Expose
    private Integer appearance;
    @SerializedName("visibleTill")
    @Expose
    private String visibleTill;
    @SerializedName("welcomescreen")
    @Expose
    private Boolean welcomescreen;
    @SerializedName("logo")
    @Expose
    private Boolean logo;
    @SerializedName("progress")
    @Expose
    private Boolean progress;
    @SerializedName("autoclose")
    @Expose
    private Boolean autoclose;
    @SerializedName("includeSegment")
    @Expose
    private IncludeSegment includeSegment;

    @SerializedName("excludeSegment")
    @Expose
    private ExcludeSegment excludeSegment;

    public String getEmbedType() {
        return embedType;
    }

    public void setEmbedType(String embedType) {
        this.embedType = embedType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getButtonTextColor() {
        return buttonTextColor;
    }

    public void setButtonTextColor(String buttonTextColor) {
        this.buttonTextColor = buttonTextColor;
    }

    public String getButtonBgColor() {
        return buttonBgColor;
    }

    public void setButtonBgColor(String buttonBgColor) {
        this.buttonBgColor = buttonBgColor;
    }

    public String getButtonPosition() {
        return buttonPosition;
    }

    public void setButtonPosition(String buttonPosition) {
        this.buttonPosition = buttonPosition;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    public Devices getDevices() {
        return devices;
    }

    public void setDevices(Devices devices) {
        this.devices = devices;
    }

    public Integer getAppearance() {
        return appearance;
    }

    public void setAppearance(Integer appearance) {
        this.appearance = appearance;
    }

    public String getVisibleTill() {
        return visibleTill;
    }

    public void setVisibleTill(String visibleTill) {
        this.visibleTill = visibleTill;
    }

    public Boolean getWelcomescreen() {
        return welcomescreen;
    }

    public void setWelcomescreen(Boolean welcomescreen) {
        this.welcomescreen = welcomescreen;
    }

    public Boolean getLogo() {
        return logo;
    }

    public void setLogo(Boolean logo) {
        this.logo = logo;
    }

    public Boolean getProgress() {
        return progress;
    }

    public void setProgress(Boolean progress) {
        this.progress = progress;
    }

    public Boolean getAutoclose() {
        return autoclose;
    }

    public void setAutoclose(Boolean autoclose) {
        this.autoclose = autoclose;
    }

    public IncludeSegment getIncludeSegment() {
        return includeSegment;
    }

    public void setIncludeSegment(IncludeSegment includeSegment) {
        this.includeSegment = includeSegment;
    }

    public ExcludeSegment getExcludeSegment() {
        return excludeSegment;
    }

    public void setExcludeSegment(ExcludeSegment excludeSegment) {
        this.excludeSegment = excludeSegment;
    }
}
