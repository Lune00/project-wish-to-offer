package com.schuhmacher.room.room;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppRoomDataBase.class, "giftsDB").addCallback(sRoomDataBaseCallBack).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDataBaseCallBack = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            Log.i("flow", "db opened");
            dataBaseWriteExecutor.execute(() -> {
                Log.i("flow", "dataBaseWriteExecutor");
                PersonDao personDao = INSTANCE.personDAO();
                personDao.deleteAll();
                personDao.insert(new PersonEntity("Paul","Schuhmacher"));
                Log.i("flow", "mock data inserted");
            });
        }
    };
}
