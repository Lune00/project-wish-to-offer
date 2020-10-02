package com.schuhmacher.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.schuhmacher.dal.repository.IPersonRepository;
import com.schuhmacher.models.Person;

import java.util.List;
import java.util.concurrent.Executor;

public class PersonViewModel extends ViewModel {

    //Repositories
    private final IPersonRepository personRepository;

    public PersonViewModel(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void insert(Person person) {
            personRepository.insert(person);
            Log.i("flow","insert person");
    }

    public LiveData<List<Person>> getAllPersons() {
        return this.personRepository.getAllLiveData();
    }
}
