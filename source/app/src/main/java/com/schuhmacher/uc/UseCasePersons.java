package com.schuhmacher.uc;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.schuhmacher.dal.repository.IPersonRepository;
import com.schuhmacher.models.Person;

import java.util.List;

public class UseCasePersons implements IUseCase {

    IPersonRepository personRepository;

    public UseCasePersons(IPersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public void addPerson(Person person){
        //Apply UseCase AddPerson (unicity)
        personRepository.insert(person);
    }

    public LiveData<List<Person>> getAll(){
        return personRepository.getAllLiveData();
    }

}
