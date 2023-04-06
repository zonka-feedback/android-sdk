package com.zonkafeedback.zfsdk.database;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zonkafeedback.zfsdk.Constant;
import com.zonkafeedback.zfsdk.retrofit.DataManager;
import com.zonkafeedback.zfsdk.utils.AppUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Base class for maintaining global application state.
 */
public class SessionCallbacks implements Application.ActivityLifecycleCallbacks, SessionHolder.SessionHolderCallback {

    public static final long CHECK_DELAY = 500;
    private final SessionHolder sessionHolder;
    private final String token;
    private Handler syncingAllowedHandler;
    private boolean isApplicationExit;
    private boolean foreground = false, paused = true;
    private Application mContext;
    private Handler handler = new Handler();
    private Runnable check;


    public SessionCallbacks(Application mContext, String token) {
        this.mContext = mContext;
        mContext.registerActivityLifecycleCallbacks(this);
        sessionHolder = new SessionHolder(mContext, this);
        this.token = token;
    }


    /**
     * Called when activity called super.onCreate().
     *
     * @param activity
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        isApplicationExit = true;

    }


    /**
     * * Called when activity called super.onStart().
     *
     * @param activity
     */
    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }


    /**
     * * Called when activity called super.onResume().
     *
     * @param activity
     */
    @Override
    public void onActivityResumed(@NonNull Activity activity) {
        paused = false;
        boolean wasBackground = !foreground;
        foreground = true;

        if (check != null)
            handler.removeCallbacks(check);

        if (wasBackground) {
            if (!TextUtils.isEmpty(token))
                DataManager.getInstance().createContact(mContext, token, true);

            if (syncingAllowedHandler != null) {
                syncingAllowedHandler.removeCallbacks(_syncingAllowedRunnable);
                syncingAllowedHandler = null;
            }

            Sessions sessions = new Sessions();
            long startTime = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis();
            AppUtils.getInstance().getCurrentTime(startTime, Constant.DATE_FORMAT);
            sessions.setStartTime(startTime);
            sessions.setId("ad-" + startTime + AppUtils.getInstance().getCookieId(14));
            sessions.setEndTime(0L);
            sessionHolder.insert(sessions, isApplicationExit);
        }
    }


    /**
     * Called when activity called super.onPause().
     *
     * @param activity
     */
    @Override
    public void onActivityPaused(@NonNull Activity activity) {
        paused = true;

        if (check != null)
            handler.removeCallbacks(check);

        handler.postDelayed(check = () -> {
            if (foreground && paused) {
                foreground = false;
                isApplicationExit = false;
                sessionHolder.updateSession(false);
                if (!TextUtils.isEmpty(token))
                    DataManager.getInstance().createContact(mContext, token, true);

                if (syncingAllowedHandler == null) {
                    syncingAllowedHandler = new Handler();
                }
                syncingAllowedHandler.postDelayed(_syncingAllowedRunnable, 20000);

            }
        }, CHECK_DELAY);


        //isApplicationExit = false;
    }

    /**
     * * Called when activity called super.onStop().
     *
     * @param activity
     */
    @Override
    public void onActivityStopped(@NonNull Activity activity) {
        isApplicationExit = false;

    }

    /*
     * Called when activity called super.onSaveInstanceState().
     */
    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

    }

    /*
     * Called when activity called super.onDestroy().
     */
    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        isApplicationExit = true;
        if (syncingAllowedHandler != null) {
            syncingAllowedHandler.removeCallbacks(_syncingAllowedRunnable);
            syncingAllowedHandler = null;
        }
    }

    @Override
    public void shareSession(ArrayList<Sessions> sessionsList) {
        if (sessionsList != null && sessionsList.size() > 0) {
            if (AppUtils.getInstance().isNetworkConnected(mContext)) {
                DataManager.getInstance().updateSessionToServer(token, sessionsList);
            }
        }
        if (syncingAllowedHandler != null) {
            syncingAllowedHandler = null;
        }
    }

    public void onSessionSave(ArrayList<String> idList) {
        if (sessionHolder != null) {
            sessionHolder.onSessionSave(idList);
        }
    }


    private final Runnable _syncingAllowedRunnable = new Runnable() {
        @Override
        public void run() {
            sessionHolder.shareSession();
        }
    };


}
