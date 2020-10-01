package com.schuhmacher.room.room.dao;

import com.schuhmacher.room.room.entities.PersonEntity;

//TODO : create interface for dao to avoid boilerplate code (source: )
public interface IPersonDAO {

    long insert(PersonEntity personEntity);
}
