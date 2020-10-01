package com.schuhmacher.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
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
    private final IInjection injection = InjectionFactory.getInjector(Configuration.getModePersistance());
    private Toolbar toolbar;
    private FloatingActionButton fabAddPerson;
    private ListPersonsAdapter adapter;

    private final int toolBarId = R.id.toolbar;
    private final int recyclerViewId = R.id.personsRecyclerView;
    private final int floatingActionButtonId = R.id.floatingActionButtonAddPerson;
    private final int menuItemActionAddPersonId = R.id.action_addPerson;
    private final int menuItemActionSettingsId = R.id.action_settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Test data
        //PersonViewModel personViewModel = this.injection.provideViewModelFactory(getApplicationContext()).create(PersonViewModel.class);
//        List<Person> persons = new ArrayList<>();
//        //Fetch test data:
//        for(int i = 0 ; i != 50; i++){
//            persons.add(new Person("Schuhmacher", "Paul", "Polo", new Date(1990, 6, 21)));
//            persons.add(new Person("Rochas", "Fanny", "Fanette", new Date(1989, 8, 15)));
//        }

        PersonViewModel personViewModel = this.injection.provideViewModelFactory(getApplicationContext()).create(PersonViewModel.class);

        loadTooBar(toolBarId);
        loadRecyclerView(recyclerViewId, new LinearLayoutManager(this), new ListPersonsAdapter());
        loadFloatingActionButton(floatingActionButtonId);

        //UI Observers added on data (adapter track changes and updates its own cache)
        personViewModel.getAllPersons().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> persons) {
                adapter.updateData(persons);
            }
        });
    }

    private void loadTooBar(final int toolBarId){
        toolbar = (Toolbar) findViewById(toolBarId);
        setSupportActionBar(toolbar);
    }

    private void loadFloatingActionButton(final int floatingActionButtonId){
        fabAddPerson = findViewById(floatingActionButtonId);
        fabAddPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAddPersonActivity();
            }
        });
    }

    private void loadRecyclerView(final int recyclerViewId, RecyclerView.LayoutManager layoutManager, ListPersonsAdapter adapter){
        recyclerView = (RecyclerView) findViewById(recyclerViewId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        this.adapter = adapter;
        recyclerView.setAdapter(adapter);
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
            case menuItemActionAddPersonId:
                startAddPersonActivity();
                return true;
            case menuItemActionSettingsId:
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