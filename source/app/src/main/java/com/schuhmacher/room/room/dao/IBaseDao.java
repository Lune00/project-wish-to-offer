package com.schuhmacher.room.room.dao;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

public interface IBaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    long insert(T t);
}
