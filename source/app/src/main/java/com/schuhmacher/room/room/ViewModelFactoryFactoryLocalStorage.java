package com.schuhmacher.room.room;

import android.content.Context;
import com.schuhmacher.injection.IViewModelFactoryFactory;
import com.schuhmacher.viewmodels.ViewModelFactory;
import com.schuhmacher.room.room.repository.PersonRepository;


//Inject the repository into the ViewModel corresponding to the persistence mode choosen (see Configuration class)
public class ViewModelFactoryFactoryLocalStorage implements IViewModelFactoryFactory {

    //Returns ViewModels with Repository Implementation specific to Room persistance
    public ViewModelFactory provideViewModelFactory(Context context) {
        PersonRepository personRepository = providePersonRepository(context);
        return new ViewModelFactory(personRepository);
    }

    private PersonRepository providePersonRepository(Context context) {
        AppRoomDataBase db = AppRoomDataBase.getDataBaseInstance(context);
        return new PersonRepository(db.personDAO());
    }

}

