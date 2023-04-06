package com.zonkafeedback.zfsdk.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Objects are the main classes where you define your database interactions. They can include a variety of query methods.
 */
@Dao
public interface SessionDao {


    @Query("SELECT * FROM zf_session ORDER BY id DESC")
    List<Sessions> getAllSessions();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertSessions(Sessions sessionEntity);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateSessions(Sessions sessionEntity);

    @Query("DELETE FROM zf_session WHERE id = :id")
    void deleteSessions(String id);


}
