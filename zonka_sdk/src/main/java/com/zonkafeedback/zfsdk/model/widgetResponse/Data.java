package com.zonkafeedback.zfsdk.model.widgetResponse;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("distributionInfo")
    @Expose
    private DistributionInfo distributionInfo;

    public DistributionInfo getDistributionInfo() {
        return distributionInfo;
    }

    public void setDistributionInfo(DistributionInfo distributionInfo) {
        this.distributionInfo = distributionInfo;
    }

}
