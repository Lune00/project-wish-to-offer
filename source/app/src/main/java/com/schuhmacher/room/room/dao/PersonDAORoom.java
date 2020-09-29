package com.schuhmacher.room.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.schuhmacher.dal.dao.IPersonDAO;
import com.schuhmacher.room.room.entities.PersonEntity;

@Dao
public abstract class PersonDAORoom implements IPersonDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long insert(PersonEntity personEntity);

}
