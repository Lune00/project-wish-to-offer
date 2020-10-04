package com.schuhmacher.dal.repository;

import androidx.lifecycle.LiveData;

import com.schuhmacher.models.Person;
import java.util.List;


public interface IPersonRepository {
    void insert(Person person);
    List<Person> getAll();
    LiveData<List<Person>> getAllLiveData();
}
