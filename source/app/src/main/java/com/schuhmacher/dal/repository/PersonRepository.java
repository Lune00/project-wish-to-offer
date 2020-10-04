package com.schuhmacher.dal.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.schuhmacher.models.Person;
import com.schuhmacher.dal.room.AppRoomDataBase;
import com.schuhmacher.dal.room.dao.PersonDao;
import com.schuhmacher.dal.room.entities.PersonEntity;
import com.schuhmacher.dal.mappers.MapperPersonModelEntity;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements IPersonRepository {

    private PersonDao personDao;

    public PersonRepository(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public void insert(Person person) {
        final PersonEntity personEntity = MapperPersonModelEntity.PersonModelToEntity(person);
        AppRoomDataBase.dataBaseWriteExecutor.execute(() -> {
            personDao.insert(personEntity);
        });
    }

    //TODO : UNIT TEST (should be updated when db  changes), for User Case (BL)
    @Override
    public List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        List<PersonEntity> personEntities = personDao.getAll().getValue();
        for (PersonEntity entity : personEntities) {
            persons.add(MapperPersonModelEntity.PersonEntityToModel(entity));
        }
        return persons;
    }

    //Return LiveData map to Person(model) for Presenter/UI only
    public LiveData<List<Person>> getAllLiveData() {
        LiveData<List<Person>> personModelsLD = Transformations.map(personDao.getAll(), newData -> createPersonModel(newData));
        return personModelsLD;
    }

    /**
     * Helper function :
     *
     * @param entities
     * @return Person models
     */
    List<Person> createPersonModel(List<PersonEntity> entities) {
        List<Person> persons = new ArrayList<>();
        for (PersonEntity entity : entities) {
            persons.add(MapperPersonModelEntity.PersonEntityToModel(entity));
        }
        return persons;
    }
}
