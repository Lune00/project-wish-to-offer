package com.schuhmacher.injection;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.schuhmacher.dal.repository.IPersonRepository;
import com.schuhmacher.viewmodels.PersonViewModel;

import java.util.concurrent.Executor;

public class ViewModelFactory implements ViewModelProvider.Factory {


    private final IPersonRepository personRepository;
    private final Executor executor;

    public ViewModelFactory(IPersonRepository personRepository, Executor executor){
        this.personRepository = personRepository;
        this.executor = executor;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass.isAssignableFrom(PersonViewModel.class)){
            return (T) new PersonViewModel(personRepository, executor);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
