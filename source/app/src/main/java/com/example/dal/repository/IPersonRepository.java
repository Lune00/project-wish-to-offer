package com.example.dal.repository;


import com.example.entities.PersonEntity;

public interface IPersonRepository {
    PersonEntity get(int id);
    void add(PersonEntity person);

//    void update(Person person);
//    void remove(Person person);
}
