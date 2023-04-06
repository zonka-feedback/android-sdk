package com.zonkafeedback.zfsdk.interfaces;

import com.zonkafeedback.zfsdk.model.widgetResponse.Widget;

import java.util.ArrayList;

/**
 * Interface used to pass data from API to ZFSurvey class
 */
public interface ApiResponseCallbacks {

    void onWidgetSuccess(Widget widget, boolean isSurveyInitialize);

    void onSessionUpdateSuccess(ArrayList<String> idList);

    void onContactCreationSuccess(boolean isContactCreated);
}
