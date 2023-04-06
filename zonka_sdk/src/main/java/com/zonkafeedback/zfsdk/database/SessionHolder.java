package com.zonkafeedback.zfsdk.database;

import android.app.Application;

import com.zonkafeedback.zfsdk.retrofit.DataManager;
import com.zonkafeedback.zfsdk.utils.AppUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class SessionHolder {

    private final SessionDao sessionDao;
    private final SessionHolderCallback sessionHolderCallback;

    public SessionHolder(Application application, SessionHolderCallback sessionHolderCallback) {
        SessionDatabase db = SessionDatabase.getDatabase(application);
        sessionDao = db.sessionDao();
        this.sessionHolderCallback = sessionHolderCallback;

    }


    void insert(Sessions sessions, boolean isApplicationExit) {
        SessionDatabase.databaseWriteExecutor.execute(() -> {
            if (isLastSessionContinue() && !isApplicationExit) {
                updateSession(true);
            } else {
                if (getAllSessions().size() > 0) {
                    sessionHolderCallback.shareSession(getAllSessions());
                }
                sessionDao.insertSessions(sessions);
            }

        });
    }

    private boolean isLastSessionContinue() {
        if (getCurrentSession() != null) {
            return AppUtils.getInstance().calculateDifferenceTime(getCurrentSession().getEndTime());
        } else {
            return false;
        }
    }

    public ArrayList<Sessions> getAllSessions() {
        return (ArrayList<Sessions>) sessionDao.getAllSessions();
    }


    void updateSession(boolean isLastSessionUpdate) {
        SessionDatabase.databaseWriteExecutor.execute(() -> {
            if (getCurrentSession() != null) {
                Sessions sessions = getCurrentSession();

                if (isLastSessionUpdate) {
                    sessions.setEndTime(0L);
                } else {
                    if (sessions.getEndTime() == 0L) {
                        long sessionEndTime = Calendar.getInstance().getTimeInMillis();
                        DataManager.getInstance().setSessionEndTime(sessionEndTime);
                        sessions.setEndTime(sessionEndTime);
                    }
                }
                sessionDao.updateSessions(sessions);
            }
        });
    }


    private Sessions getCurrentSession() {
        List<Sessions> sessionList = sessionDao.getAllSessions();
        if (sessionList.size() > 0) {
            return sessionList.get(0);
        } else {
            return null;
        }
    }

    public void onSessionSave(ArrayList<String> idList) {
        SessionDatabase.databaseWriteExecutor.execute(() -> {
            for (int i = 0; i < idList.size(); i++) {
                sessionDao.deleteSessions(idList.get(i));
            }
        });

    }

    public void shareSession(){
        SessionDatabase.databaseWriteExecutor.execute(() -> {
                if (getAllSessions().size() > 0) {
                    sessionHolderCallback.shareSession(getAllSessions());
                }
        });
    }


    public interface SessionHolderCallback {
        void shareSession(ArrayList<Sessions> sessionsList);
    }

}
