package com.schuhmacher.room.room.repository;

import androidx.lifecycle.LiveData;
import com.schuhmacher.dal.dao.IPersonDAO;
import com.schuhmacher.room.room.dao.PersonDAORoom;
import com.schuhmacher.dal.repository.IPersonRepository;
import com.schuhmacher.room.room.entities.PersonEntity;

import java.util.List;

public class PersonRepository implements IPersonRepository {

    private IPersonDAO personDao;
    private LiveData<List<PersonEntity>> persons;

    public PersonRepository(PersonDAORoom personDAORoom){
        personDao = personDAORoom;
    }

    @Override
    public void insert(PersonEntity person) {
        personDao.insert(person);
    }
}
