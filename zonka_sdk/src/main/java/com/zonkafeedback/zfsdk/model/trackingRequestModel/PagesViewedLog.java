
package com.zonkafeedback.zfsdk.model.trackingRequestModel;

import java.io.Serializable;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PagesViewedLog implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("referal")
    @Expose
    private String referal;
    public final static Creator<PagesViewedLog> CREATOR = new Creator<PagesViewedLog>() {


        public PagesViewedLog createFromParcel(android.os.Parcel in) {
            return new PagesViewedLog(in);
        }

        public PagesViewedLog[] newArray(int size) {
            return (new PagesViewedLog[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6193601567800517212L;

    @SuppressWarnings({
        "unchecked"
    })
    protected PagesViewedLog(android.os.Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.path = ((String) in.readValue((String.class.getClassLoader())));
        this.referal = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PagesViewedLog() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getReferal() {
        return referal;
    }

    public void setReferal(String referal) {
        this.referal = referal;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(title);
        dest.writeValue(path);
        dest.writeValue(referal);
    }

    public int describeContents() {
        return  0;
    }

}
