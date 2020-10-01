package com.schuhmacher.room.room;


import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.schuhmacher.room.room.dao.PersonDao;
import com.schuhmacher.room.room.entities.PersonEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {PersonEntity.class}, version = 1, exportSchema = false)

public abstract class AppRoomDataBase extends RoomDatabase {

    public abstract PersonDao personDAO();

    private static volatile AppRoomDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService dataBaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppRoomDataBase getDataBaseInstance(final Context context) {

        if (INSTANCE == null) {
            synchronized (AppRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppRoomDataBase.class, "giftsDB").build();
                }
            }
        }
        return INSTANCE;
    }
}
