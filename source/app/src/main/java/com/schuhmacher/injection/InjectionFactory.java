package com.schuhmacher.injection;

import com.schuhmacher.Configuration;
import com.schuhmacher.room.room.ViewModelFactoryFactoryLocalStorage;

public class InjectionFactory {

    //TODO: is there a better way than an if statement to choose?....
    public static IViewModelFactoryFactory getInjector(Configuration.ModePersistance modePersistance) {

        switch (modePersistance) {
            case LocalRoomDataBase : return new ViewModelFactoryFactoryLocalStorage();
            default: throw new IllegalArgumentException("ModePersistance unknown!");
        }

    }
}
