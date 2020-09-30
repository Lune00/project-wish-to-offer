package com.schuhmacher.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.schuhmacher.Configuration;
import com.schuhmacher.injection.IInjection;
import com.schuhmacher.injection.InjectionFactory;
import com.schuhmacher.viewmodels.PersonViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private IInjection injection = InjectionFactory.getInjector(Configuration.getModePersistance());


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recycler view
        recyclerView = (RecyclerView) findViewById(R.id.personsRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
//
//        //ViewModel injected through InjectionRoom (implementation of the injection interface) and ViewModelFactory
//        PersonViewModel personViewModel= InjectionRoom.provideViewModelFactory(getApplicationContext()).create(PersonViewModel.class);

        PersonViewModel personViewModel = this.injection.provideViewModelFactory(getApplicationContext()).create(PersonViewModel.class);


    }
}