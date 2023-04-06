package com.example.zonkasdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.zonkafeedback.zfsdk.ZFSurvey;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("contact_mobile", "99999999");
        hashMap.put("contact_email", "namixyz@gmail.com");
        hashMap.put("contact_uniqueId", "123456789");
        hashMap.put("contact_name", "Namish Garg");
        ZFSurvey.getInstance().userInfo(hashMap);
        findViewById(R.id.click).setOnClickListener(v -> {
            ZFSurvey.getInstance()
                    .startSurvey(this);
        });

        findViewById(R.id.log_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZFSurvey.getInstance().clear();
            }
        });

    }


}