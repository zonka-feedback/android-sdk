
package com.zonkafeedback.zfsdk.model.sessionResponseModel;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("savedUniqueSessions")
    @Expose
    private ArrayList<String> savedUniqueSessions = null;

    public ArrayList<String> getSavedUniqueSessions() {
        return savedUniqueSessions;
    }

    public void setSavedUniqueSessions(ArrayList<String> savedUniqueSessions) {
        this.savedUniqueSessions = savedUniqueSessions;
    }

}
