package com.schuhmacher.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


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






    }
}