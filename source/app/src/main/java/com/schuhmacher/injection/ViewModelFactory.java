package com.schuhmacher.injection;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.schuhmacher.dal.repository.IPersonRepository;
import com.schuhmacher.viewmodels.PersonViewModel;


public class ViewModelFactory implements ViewModelProvider.Factory {


    private final IPersonRepository personRepository;

    public ViewModelFactory(IPersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass.isAssignableFrom(PersonViewModel.class)){
            return (T) new PersonViewModel(personRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
