package com.schuhmacher.viewmodels;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.schuhmacher.room.room.entities.PersonEntity;
import com.schuhmacher.room.room.repository.PersonRepository;
import com.schuhmacher.room.room.mappers.MapperPersonModelEntity;
import com.schuhmacher.models.Person;

public class PersonViewModel extends ViewModel {

    //Repositories
    private final PersonRepository personRepository;

    //DATA
    @Nullable
    private LiveData<Person> persons;

    public PersonViewModel(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public void insert(Person person){
        PersonEntity personEntity = MapperPersonModelEntity.PersonModelToEntity(person);
        this.personRepository.insert(personEntity);
        return;
    }
}
