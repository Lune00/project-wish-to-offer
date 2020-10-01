package com.schuhmacher.room.room.repository;

import androidx.lifecycle.LiveData;

import com.schuhmacher.dal.dao.IPersonDAO;
import com.schuhmacher.dal.repository.IPersonRepository;
import com.schuhmacher.models.Person;
import com.schuhmacher.room.room.dao.PersonDAORoom;
import com.schuhmacher.room.room.entities.PersonEntity;
import com.schuhmacher.room.room.mappers.MapperPersonModelEntity;

import java.util.List;

public class PersonRepository implements IPersonRepository {

    private IPersonDAO personDao;
    private LiveData<List<PersonEntity>> persons;


    public PersonRepository(PersonDAORoom personDAORoom){
        personDao = personDAORoom;
    }

    @Override
    public void insert(Person person) {
        final PersonEntity personEntity = MapperPersonModelEntity.PersonModelToEntity(person);
        personDao.insert(personEntity);
    }
}
