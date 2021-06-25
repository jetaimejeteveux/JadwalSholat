package com.example.jadwalshalat.data.local;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface SholatDAO {
    @Insert
    long insertSholat(DataModel dataModel);
    @Delete
    int deleteSholat(DataModel dataModel);
    @Query("SELECT * FROM data_sholat")
    List<DataModel> getSholat();
}
