package com.zonkafeedback.zfsdk.database;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * This class will have a mapping SQLite table in the database.
 */
@Entity(tableName = "zf_session")
public class Sessions {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    @NonNull
    private String id;

    private long startTime = 0L;

    private long endTime =0L;

    public void setId(String id){
        this.id = id;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    @NonNull
    public String getId(){
        return id;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
