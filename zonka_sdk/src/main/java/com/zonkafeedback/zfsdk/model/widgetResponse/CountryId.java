
package com.zonkafeedback.zfsdk.model.widgetResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryId {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("phoneCode")
    @Expose
    private String phoneCode;
    @SerializedName("credits")
    @Expose
    private Double credits;
    @SerializedName("startWeekDay")
    @Expose
    private Integer startWeekDay;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("pre_mongified_id")
    @Expose
    private Integer preMongifiedId;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("modifiedDate")
    @Expose
    private String modifiedDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public Integer getStartWeekDay() {
        return startWeekDay;
    }

    public void setStartWeekDay(Integer startWeekDay) {
        this.startWeekDay = startWeekDay;
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
