
package com.zonkafeedback.zfsdk.model.sessionRequestModel;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateSessionRequest {

    @SerializedName("deviceType")
    @Expose
    private String deviceType;
    @SerializedName("sessionLogs")
    @Expose
    private ArrayList<SessionLog> sessionLogs = null;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public ArrayList<SessionLog> getSessionLogs() {
        return sessionLogs;
    }

    public void setSessionLogs(ArrayList<SessionLog> sessionLogs) {
        this.sessionLogs = sessionLogs;
    }

}
