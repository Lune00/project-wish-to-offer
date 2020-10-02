package com.schuhmacher.dal.repository;

import androidx.lifecycle.LiveData;

import com.schuhmacher.models.Person;
import java.util.List;

//TODO : interface for repo to avoid boilerplate code (insert, getAll, delete)
public interface IPersonRepository {

    void insert(Person person);
    List<Person> getAll();
    LiveData<List<Person>> getAllLiveData();
}
