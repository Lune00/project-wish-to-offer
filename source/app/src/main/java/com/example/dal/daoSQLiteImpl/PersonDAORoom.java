package com.example.dal.daoSQLiteImpl;

import androidx.room.Dao;

import com.example.dal.dao.IPersonDAO;
import com.example.entities.PersonEntity;

@Dao
public class PersonDAORoom implements IPersonDAO {


    @Override
    public void add(PersonEntity personEntity) {

    }
}
