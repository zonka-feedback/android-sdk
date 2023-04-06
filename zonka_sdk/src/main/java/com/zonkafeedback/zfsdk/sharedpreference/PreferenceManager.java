package com.zonkafeedback.zfsdk.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * This Class used to create and save the user information in Shared Preference.
 */
public class PreferenceManager {

    private static final String SHARED_PREF_FILE = "com.zf_sdk.ZFSurveyPref";
    private static PreferenceManager mAppSharedPreferenceInstance;
    private final SharedPreferences sharedPref;

    private PreferenceManager(Context context, String token) throws NullPointerException {
        if (context == null) {
            throw new NullPointerException("Context null Exception");
        }
        sharedPref = context.getSharedPreferences(SHARED_PREF_FILE + "." + token, Context.MODE_PRIVATE);

    }


    public static PreferenceManager getInstance() {
        if (mAppSharedPreferenceInstance == null) {
            throw new IllegalStateException("Call init() before getInstance()");
        }
        return mAppSharedPreferenceInstance;
    }


    public synchronized static void init(Context context, String token) {
        if (mAppSharedPreferenceInstance == null) {
            mAppSharedPreferenceInstance = new PreferenceManager(context, token);
        }
    }


    public Long getLong(String key) {
        return sharedPref.getLong(key, 0);
    }

    public void putLong(String key, long value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong(key, value);
        editor.apply();
    }


    public void putString(String key, String value) {

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);         // Commit the edits!
        editor.apply();
    }

    public String getString(String key, String defaultValue) {
        return sharedPref.getString(key, defaultValue);
    }


    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }


    public boolean getBoolean(String key, boolean defaultValue) {
        return sharedPref.getBoolean(key, defaultValue);
    }

    public void clearAllPrefs() {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.apply();
    }


}
