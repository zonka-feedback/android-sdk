package com.zonkafeedback.zfsdk.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * RoomDatabase provides direct access to the underlying database implementation
 * but you should prefer using Dao classes.
 */
@Database(entities = {Sessions.class}, version = 1, exportSchema = false)
abstract class SessionDatabase extends RoomDatabase {
    abstract SessionDao sessionDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile SessionDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static SessionDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SessionDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    SessionDatabase.class, "zfdb")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override the onCreate method to populate the database.
     * For this sample, we clear the database every time it is created.
     */
    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

        }
    };

}
