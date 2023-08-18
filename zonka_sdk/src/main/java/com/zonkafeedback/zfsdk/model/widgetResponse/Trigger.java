
package com.zonkafeedback.zfsdk.model.widgetResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trigger {

    @SerializedName("after")
    @Expose
    private Integer after;
    @SerializedName("scroll")
    @Expose
    private Integer scroll;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("keywords")
    @Expose
    private String keywords;

    public Integer getAfter() {
        return after;
    }

    public void setAfter(Integer after) {
        this.after = after;
    }

    public Integer getScroll() {
        return scroll;
    }

    public void setScroll(Integer scroll) {
        this.scroll = scroll;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

}
