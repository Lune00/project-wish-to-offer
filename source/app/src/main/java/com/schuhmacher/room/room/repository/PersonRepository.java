package com.schuhmacher.room.room.repository;

import androidx.lifecycle.LiveData;

import com.schuhmacher.dal.repository.IPersonRepository;
import com.schuhmacher.models.Person;
import com.schuhmacher.room.room.dao.PersonDao;
import com.schuhmacher.room.room.entities.PersonEntity;
import com.schuhmacher.room.room.mappers.MapperPersonModelEntity;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements IPersonRepository {

    private PersonDao personDao;


    public PersonRepository(PersonDao personDao){
        personDao = personDao;
    }

    @Override
    public void insert(Person person) {
        final PersonEntity personEntity = MapperPersonModelEntity.PersonModelToEntity(person);
        personDao.insert(personEntity);
    }

    //TODO : UNIT TEST (should be updated when db changes)
    //TODO : Comment faire remonter LiveData<Person> observer par l'ui sans qu'il y ait de ref vers l'entité dans l'activité?
    @Override
    public List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        List<PersonEntity> personEntities = personDao.getAll().getValue();
        for(PersonEntity entity : personEntities){
            persons.add(MapperPersonModelEntity.PersonEntityToModel(entity));
        }
        return persons;
    }
}
