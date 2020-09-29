package com.schuhmacher.room.room.mappers;

import com.schuhmacher.room.room.entities.PersonEntity;
import com.schuhmacher.models.Person;

public class MapperPersonModelEntity {

    public static PersonEntity PersonModelToEntity(Person personModel){
        return new PersonEntity(personModel.getFirstName(), personModel.getLastName());
    }

}
