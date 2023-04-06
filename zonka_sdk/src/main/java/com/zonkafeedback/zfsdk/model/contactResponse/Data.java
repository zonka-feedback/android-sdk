
package com.zonkafeedback.zfsdk.model.contactResponse;




import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("contactInfo")
    @Expose
    private ContactInfo contactInfo;
    @SerializedName("evd")
    @Expose
    private Evd evd;

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Evd getEvd() {
        return evd;
    }

    public void setEvd(Evd evd) {
        this.evd = evd;
    }

}
