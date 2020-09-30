package com.schuhmacher.viewmodels;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.schuhmacher.dal.repository.IPersonRepository;
import com.schuhmacher.models.Person;

import java.util.concurrent.Executor;

public class PersonViewModel extends ViewModel {

    //Repositories
    private final IPersonRepository personRepository;
    private final Executor executor;

    //DATA
    @Nullable
    private LiveData<Person> persons;

    public PersonViewModel(IPersonRepository personRepository, Executor executor){
        this.personRepository = personRepository;
        this.executor = executor;
    }

    public void insert(Person person){
       executor.execute(() -> {
           personRepository.insert(person);
       });
    }
}
