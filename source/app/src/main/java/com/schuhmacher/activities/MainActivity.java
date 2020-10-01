package com.schuhmacher.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.schuhmacher.Configuration;
import com.schuhmacher.activities.adapters.ListPersonsAdapter;
import com.schuhmacher.injection.IInjection;
import com.schuhmacher.injection.InjectionFactory;
import com.schuhmacher.models.Person;
import com.schuhmacher.viewmodels.PersonViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private IInjection injection = InjectionFactory.getInjector(Configuration.getModePersistance());
    private Toolbar toolbar;
    private FloatingActionButton fabAddPerson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //FAB addPerson
        fabAddPerson = findViewById(R.id.floatingActionButtonAddPerson);
        fabAddPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAddPersonActivity();
            }
        });

        //Test data
        //PersonViewModel personViewModel = this.injection.provideViewModelFactory(getApplicationContext()).create(PersonViewModel.class);
        List<Person> persons = new ArrayList<>();
        //Fetch test data:
        for(int i = 0 ; i != 50; i++){
            persons.add(new Person("Schuhmacher", "Paul", "Polo", new Date(1990, 6, 21)));
            persons.add(new Person("Rochas", "Fanny", "Fanette", new Date(1989, 8, 15)));
        }


        //Recycler view
        recyclerView = (RecyclerView) findViewById(R.id.personsRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ListPersonsAdapter(persons);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        Log.i("test", "on resume");
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_addPerson:
                startAddPersonActivity();
                return true;
            case R.id.action_settings:
                startSettingsActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void startAddPersonActivity() {
        Intent intent = new Intent(this, AddPersonActivity.class);
        startActivity(intent);
    }

    public void startSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}