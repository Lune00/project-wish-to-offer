package com.schuhmacher.room.room.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PersonEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "first_name")
    @NonNull
    public String firstName;

    @ColumnInfo(name = "last_name")
    @NonNull
    public String lastName;

    public PersonEntity(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
