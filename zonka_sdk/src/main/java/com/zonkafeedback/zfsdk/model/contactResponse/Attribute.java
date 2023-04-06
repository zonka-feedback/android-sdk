package com.zonkafeedback.zfsdk.model.contactResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attribute {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("5e12d8c8ee2f084102f1ccc2")
    @Expose
    private String _5e12d8c8ee2f084102f1ccc2;
    @SerializedName("contact_country")
    @Expose
    private String contactCountry;
    @SerializedName("type")
    @Expose
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String get5e12d8c8ee2f084102f1ccc2() {
        return _5e12d8c8ee2f084102f1ccc2;
    }

    public void set5e12d8c8ee2f084102f1ccc2(String _5e12d8c8ee2f084102f1ccc2) {
        this._5e12d8c8ee2f084102f1ccc2 = _5e12d8c8ee2f084102f1ccc2;
    }

    public String getContactCountry() {
        return contactCountry;
    }

    public void setContactCountry(String contactCountry) {
        this.contactCountry = contactCountry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
