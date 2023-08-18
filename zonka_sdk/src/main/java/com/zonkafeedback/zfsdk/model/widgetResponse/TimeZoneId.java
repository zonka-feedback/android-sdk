
package com.zonkafeedback.zfsdk.model.widgetResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeZoneId {

    @SerializedName("timeZone")
    @Expose
    private String timeZone;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("tzOffset")
    @Expose
    private String tzOffset;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("pre_mongified_id")
    @Expose
    private Integer preMongifiedId;
    @SerializedName("tzOffsetSec")
    @Expose
    private String tzOffsetSec;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("modifiedDate")
    @Expose
    private String modifiedDate;

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTzOffset() {
        return tzOffset;
    }

    public void setTzOffset(String tzOffset) {
        this.tzOffset = tzOffset;
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

    public String getTzOffsetSec() {
        return tzOffsetSec;
    }

    public void setTzOffsetSec(String tzOffsetSec) {
        this.tzOffsetSec = tzOffsetSec;
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

}
