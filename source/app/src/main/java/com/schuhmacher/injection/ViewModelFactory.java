package com.schuhmacher.injection;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.schuhmacher.uc.UseCasePersons;
import com.schuhmacher.viewmodels.ListPersonsViewModel;


public class ViewModelFactory implements ViewModelProvider.Factory {

    private UseCasePersons useCasePersons;

    public ViewModelFactory(UseCasePersons useCasePersons){
        this.useCasePersons = useCasePersons;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass.isAssignableFrom(ListPersonsViewModel.class)){
            return (T) new ListPersonsViewModel(useCasePersons);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
