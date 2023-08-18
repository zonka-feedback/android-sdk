
package com.zonkafeedback.zfsdk.model.widgetResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("distributionInfo")
    @Expose
    private DistributionInfo distributionInfo;
    @SerializedName("companyInfo")
    @Expose
    private CompanyInfo companyInfo;
    @SerializedName("contactInfo")
    @Expose
    private Object contactInfo;

    public DistributionInfo getDistributionInfo() {
        return distributionInfo;
    }

    public void setDistributionInfo(DistributionInfo distributionInfo) {
        this.distributionInfo = distributionInfo;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    public Object getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Object contactInfo) {
        this.contactInfo = contactInfo;
    }

}
