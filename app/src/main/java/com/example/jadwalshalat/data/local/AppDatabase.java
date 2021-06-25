package com.example.jadwalshalat.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;
    public abstract SholatDAO sholatDAO();

    public static AppDatabase initDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "sholat").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
