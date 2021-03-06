package com.schuhmacher.dal.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.schuhmacher.dal.room.entities.PersonEntity;

import java.util.List;

@Dao
public abstract class PersonDao implements IBaseDao<PersonEntity> {

    @Query("SELECT * FROM person_table")
    public abstract LiveData<List<PersonEntity>> getAll();
    @Query("DELETE FROM person_table")
    public abstract void deleteAll();

}
