package com.schuhmacher.injection;

import android.content.Context;

import com.schuhmacher.dal.repository.IPersonRepository;
import com.schuhmacher.dal.repository.PersonRepository;
import com.schuhmacher.dal.room.AppRoomDataBase;
import com.schuhmacher.uc.UseCasePersons;

public class Injection {

    public static IPersonRepository providePersonsRepository(Context context){
        AppRoomDataBase appRoomDataBase = AppRoomDataBase.getDataBaseInstance(context);
        return new PersonRepository(appRoomDataBase.personDAO());
    }

    public static UseCasePersons provideUseCasePersons(Context context){
        IPersonRepository personRepository = providePersonsRepository(context);
        return new UseCasePersons(personRepository);
    }

    public static ViewModelFactory provideViewModelFactory(Context context){
        UseCasePersons useCasePersons = provideUseCasePersons(context);
        return new ViewModelFactory(useCasePersons);
    }
}
