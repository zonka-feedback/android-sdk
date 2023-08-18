
package com.zonkafeedback.zfsdk.model.widgetResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IncludeSegment {

    @SerializedName("list")
    @Expose
    private List<String> list;
    @SerializedName("type")
    @Expose
    private String type;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
