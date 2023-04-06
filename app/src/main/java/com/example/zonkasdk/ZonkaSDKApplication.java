package com.example.zonkasdk;

import android.app.Application;

import com.zonkafeedback.zfsdk.ZFSurvey;


public class ZonkaSDKApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ZFSurvey.init(this, "rQo87Y","US"); //KPqh15  6e4RWo
    }

}
