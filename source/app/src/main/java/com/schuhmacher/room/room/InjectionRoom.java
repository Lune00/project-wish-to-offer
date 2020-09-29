package com.schuhmacher.room.room;

import android.content.Context;
import com.schuhmacher.injection.IInjection;
import com.schuhmacher.injection.ViewModelFactory;
import com.schuhmacher.room.room.repository.PersonRepository;
import java.util.concurrent.Executor;

//Implementation of the injection interface for Room persistence
public class InjectionRoom implements IInjection<PersonRepository> {

    public PersonRepository providePersonRepository(Context context) {
        AppRoomDataBase db = AppRoomDataBase.getDataBaseInstance(context);
        return new PersonRepository(db.personDAO());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        PersonRepository personRepository = new InjectionRoom().providePersonRepository(context);
        Executor executor = IInjection.provideExecutor();
        return new ViewModelFactory(personRepository, executor);
    }

}

