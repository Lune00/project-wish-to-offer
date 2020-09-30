package com.schuhmacher.injection;

import com.schuhmacher.Configuration;
import com.schuhmacher.room.room.InjectionRoom;

public class InjectionFactory {

    //TODO: is there a better way than an if statement to choose?....
    public static IInjection getInjector(Configuration.ModePersistance modePersistance) {

        switch (modePersistance) {
            case LocalRoomDataBase : return new InjectionRoom();
            default: throw new IllegalArgumentException("ModePersistance unknown!");
        }

    }
}
