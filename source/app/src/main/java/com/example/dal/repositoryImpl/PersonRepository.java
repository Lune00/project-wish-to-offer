package com.example.dal.repositoryImpl;

import androidx.lifecycle.LiveData;
import com.example.dal.AppRoomDataBase;
import com.example.dal.dao.IPersonDAO;
import com.example.dal.daoSQLiteImpl.PersonDAORoom;
import com.example.dal.repository.IPersonRepository;
import com.example.entities.PersonEntity;


import java.util.List;

public class PersonRepository implements IPersonRepository {

    private IPersonDAO personDao;
    private LiveData<List<PersonEntity>> persons;

    PersonRepository(PersonDAORoom personDao){

    }

    @Override
    public PersonEntity get(int id) {
        return null;
    }

    @Override
    public void add(PersonEntity person) {

    }
}
