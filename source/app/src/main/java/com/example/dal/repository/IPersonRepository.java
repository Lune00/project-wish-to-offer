package com.example.dal.repository;

import com.example.entities.Person;

public interface IPersonRepository {
    Person get(int id);
    void add(Person person);
    void update(Person person);
    void remove(Person person);
}
