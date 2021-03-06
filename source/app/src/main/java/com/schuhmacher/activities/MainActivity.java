package com.schuhmacher.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.schuhmacher.activities.adapters.ListPersonsAdapter;
import com.schuhmacher.injection.Injection;
import com.schuhmacher.viewmodels.ListPersonsViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
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

        Log.e("flow","onCreate");

        ViewModelProvider.Factory factory = Injection.provideViewModelFactory(this);
        ListPersonsViewModel vm = new ViewModelProvider(this, factory).get(ListPersonsViewModel.class);

        loadToolBar(toolBarId);
        loadRecyclerView(recyclerViewId, new LinearLayoutManager(this), new ListPersonsAdapter());
        loadFloatingActionButton(floatingActionButtonId);

        //UI Observers added on data (adapter track changes and updates its own cache)
        vm.getAllPersons().observe(this, persons -> {
            Log.e("flow","data has changed : " + persons.toString());
            adapter.updateData(persons);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("flow","onResume");
    }

    private void loadToolBar(final int toolBarId) {
        toolbar = (Toolbar) findViewById(toolBarId);
        setSupportActionBar(toolbar);
    }

    private void loadFloatingActionButton(final int floatingActionButtonId) {
        fabAddPerson = findViewById(floatingActionButtonId);
        fabAddPerson.setOnClickListener(v -> startAddPersonActivity());
    }

    private void loadRecyclerView(final int recyclerViewId, RecyclerView.LayoutManager layoutManager, ListPersonsAdapter adapter) {
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