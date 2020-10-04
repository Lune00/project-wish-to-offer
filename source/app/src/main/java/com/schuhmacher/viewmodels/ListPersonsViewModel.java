package com.schuhmacher.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.schuhmacher.models.Person;
import com.schuhmacher.uc.UseCasePersons;

import java.util.List;

public class ListPersonsViewModel extends ViewModel {

    //UC
    public UseCasePersons useCasePersons;

    //Data
    private LiveData<List<Person>> persons;

    public ListPersonsViewModel(UseCasePersons useCasePersons) {
        this.useCasePersons = useCasePersons;
        this.persons = useCasePersons.getAll();
    }

    public LiveData<List<Person>> getAllPersons(){
        return this.persons;
    }
}
