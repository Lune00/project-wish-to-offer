package com.example.dal.dao;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.entities.PersonEntity;

public interface IPersonDAO {

    void add(PersonEntity personEntity);

//    @Query("SELECT * FROM PersonEntity ")
//    LiveData<List<PersonEntity>> getAllPersons();
//    void update(PersonEntity personEntity);
//    void remove(PersonEntity personEntity);
}
