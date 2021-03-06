package com.schuhmacher.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.schuhmacher.models.Person;

import java.util.Date;

public class AddPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.action_add_person));
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Focus on create activity
        TextInputEditText TextInputEditText = (TextInputEditText) findViewById(R.id.TextInputLayoutPersonFirstName);
        TextInputEditText.requestFocus();

        //TODO : instanciate ViewModel here and setup observers on its liveData(firstName, lastName)

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_person_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_save_person:
                onSavePerson();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onSavePerson() {

        //TODO : data should be fetched from FormValidationViewModelPerson
        final TextInputEditText textInputEditTextFirstName = (TextInputEditText) findViewById(R.id.TextInputLayoutPersonFirstName);
        final TextInputEditText textInputEditTextLastName = (TextInputEditText) findViewById(R.id.TextInputLayoutPersonLastName);
        final String firstName = textInputEditTextFirstName.getText().toString();
        final String lastName = textInputEditTextLastName.getText().toString();
        Person person = new Person(firstName, lastName, "FOO", new Date(0));

        //TODO : Form Validation and

        resumeActivityListPersons();
    }

    private void resumeActivityListPersons(){
        finish();
    }
}