package com.example.dal.repository;

import com.example.dal.DAOFactory;
import com.example.dal.dao.IPersonDAO;
import com.example.entities.Person;

public class PersonRepository {

    private IPersonDAO dao = DAOFactory.getPersonDAO();

    void insert(final Person person) {
        dao.insert(person);
    }
}
