package com.zonkafeedback.zfsdk.model.widgetResponse;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistributionInfo {


    @SerializedName("isWidgetActive")
    @Expose
    private Boolean isWidgetActive;

    @SerializedName("companyId")
    @Expose
    private String companyId;


    public Boolean getIsWidgetActive() {
        return isWidgetActive;
    }

    public void setIsWidgetActive(Boolean isWidgetActive) {
        this.isWidgetActive = isWidgetActive;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

}
