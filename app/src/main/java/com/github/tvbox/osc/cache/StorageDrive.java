package com.github.tvbox.osc.cache;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "storageDrive")
public class StorageDrive {
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "type")
    public int type;
    @ColumnInfo(name = "configJson")
    public String configJson;
    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
