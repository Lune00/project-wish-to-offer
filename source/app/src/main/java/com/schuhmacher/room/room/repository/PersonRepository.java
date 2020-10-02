package com.schuhmacher.room.room.repository;

import androidx.lifecycle.LiveData;

import com.schuhmacher.dal.repository.IPersonRepository;
import com.schuhmacher.models.Person;
import com.schuhmacher.room.room.dao.PersonDao;
import com.schuhmacher.room.room.entities.PersonEntity;
import com.schuhmacher.room.room.mappers.MapperPersonModelEntity;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements IPersonRepository {

    private PersonDao personDao;

    public PersonRepository(PersonDao personDao){
        personDao = personDao;
    }

    @Override
    public void insert(Person person) {
        final PersonEntity personEntity = MapperPersonModelEntity.PersonModelToEntity(person);
        personDao.insert(personEntity);
    }

    //TODO : UNIT TEST (should be updated when db changes), for User Case (BL)
    @Override
    public List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        List<PersonEntity> personEntities = personDao.getAll().getValue();
        for(PersonEntity entity : personEntities){
            persons.add(MapperPersonModelEntity.PersonEntityToModel(entity));
        }
        return persons;
    }

    //TODO : Comment faire remonter LiveData<Person> observer par l'ui sans qu'il y ait de ref vers l'entité dans l'activité?
    //Faire un observer ici sur liveData<Entity> qui met a jour un liveData<Person> qui sera lui meme observé depuis l'activité?
    //See Transformation of LiveData and link : https://proandroiddev.com/clean-easy-new-how-to-architect-your-app-part-4-livedata-transformations-f0fd9f313ec6
    //TODO Return LiveData map to Person(model) for Presenter/UI only
    public LiveData<List<Person>> getAllLiveData(){

        //TODO
        return null;
    }
}
