package com.schuhmacher.viewmodels;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.schuhmacher.dal.repository.IPersonRepository;


public class ViewModelFactory implements ViewModelProvider.Factory {


    private final IPersonRepository personRepository;

    public ViewModelFactory(IPersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        Log.e("flow","create of ViewModelProvide.Factory called");
        if(modelClass.isAssignableFrom(PersonViewModel.class)){
            return (T) new PersonViewModel(personRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
