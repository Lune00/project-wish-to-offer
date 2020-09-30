package com.schuhmacher.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.schuhmacher.Configuration;
import com.schuhmacher.injection.IInjection;
import com.schuhmacher.injection.InjectionFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private IInjection injection = InjectionFactory.getInjector(Configuration.getModePersistance());


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Recycler view
        recyclerView = (RecyclerView) findViewById(R.id.personsRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //FAB addPerson
        //TODO: do properly Fab AddPerson
        FloatingActionButton fabAddPerson = findViewById(R.id.floatingActionButtonAddPerson);
        fabAddPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAddPersonActivity();
            }
        });

//        PersonViewModel personViewModel = this.injection.provideViewModelFactory(getApplicationContext()).create(PersonViewModel.class);
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

    public void startSettingsActivity(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}