package com.schuhmacher.dal.mappers;

import com.schuhmacher.dal.room.entities.PersonEntity;
import com.schuhmacher.models.Person;

import java.util.Date;

public class MapperPersonModelEntity {

    public static PersonEntity PersonModelToEntity(Person personModel){
        return new PersonEntity(personModel.getFirstName(), personModel.getLastName());
    }

    public static Person PersonEntityToModel(PersonEntity entity) {
        return new Person(entity.firstName, entity.lastName, "FOO", new Date(0) );
    }
}
