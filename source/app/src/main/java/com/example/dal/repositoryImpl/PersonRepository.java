package com.example.dal.repositoryImpl;

import com.example.dal.DAOFactory;
import com.example.dal.dao.IPersonDAO;
import com.example.dal.repository.IPersonRepository;
import com.example.entities.Person;

public class PersonRepository implements IPersonRepository {

    private IPersonDAO dao = DAOFactory.getPersonDAO();

    @Override
    public Person get(int id) {
        return null;
    }

    @Override
    public void remove(Person person) {
        return;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void add(Person person) {

    }
}
