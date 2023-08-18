
package com.zonkafeedback.zfsdk.model.widgetResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Devices {

    @SerializedName("desktop")
    @Expose
    private Boolean desktop;
    @SerializedName("tablet")
    @Expose
    private Boolean tablet;
    @SerializedName("mobile")
    @Expose
    private Boolean mobile;

    public Boolean getDesktop() {
        return desktop;
    }

    public void setDesktop(Boolean desktop) {
        this.desktop = desktop;
    }

    public Boolean getTablet() {
        return tablet;
    }

    public void setTablet(Boolean tablet) {
        this.tablet = tablet;
    }

    public Boolean getMobile() {
        return mobile;
    }

    public void setMobile(Boolean mobile) {
        this.mobile = mobile;
    }

}
