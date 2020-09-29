package com.schuhmacher.room.room;

import android.content.Context;
import com.schuhmacher.injection.ViewModelFactory;
import com.schuhmacher.room.room.repository.PersonRepository;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Injection {

    public static PersonRepository providePersonRepository(Context context) {
        AppRoomDataBase db = AppRoomDataBase.getDataBaseInstance(context);
        return new PersonRepository(db.personDAO());
    }

    public static Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        PersonRepository personRepository = providePersonRepository(context);
        Executor executor = provideExecutor();
        return new ViewModelFactory(personRepository, executor);
    }
}

