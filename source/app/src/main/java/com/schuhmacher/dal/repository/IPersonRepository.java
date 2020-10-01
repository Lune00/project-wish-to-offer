package com.schuhmacher.dal.repository;

import com.schuhmacher.models.Person;
import java.util.List;

//TODO : interface for repo to avoid boilerplate code (insert, getAll, delete)
public interface IPersonRepository {

    void insert(Person person);
    List<Person> getAll();
}
