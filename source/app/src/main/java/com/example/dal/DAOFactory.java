package com.example.dal;

import com.example.dal.dao.IPersonDAO;
import com.example.dal.daoTestImpl.PersonDAOTestImpl;

public final class DAOFactory {

    public static IPersonDAO getPersonDAO() {
        IPersonDAO personDAO = new PersonDAOTestImpl();
        return personDAO;
    }
}
