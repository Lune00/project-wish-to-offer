package com.schuhmacher.activities.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.schuhmacher.activities.R;
import com.schuhmacher.models.Person;

import java.util.ArrayList;
import java.util.List;


/**
 * Adapter for the Persons List
 */
public class ListPersonsAdapter extends RecyclerView.Adapter<ListPersonsAdapter.PersonViewHolder> {

    private List<Person> persons = new ArrayList<>();

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.textViewFirstName);
        }
    }

    public ListPersonsAdapter() {
    }

    public void updateData(List<Person> persons) {
        Log.e("flow", "adapter update : before" + this.persons + "after : " + persons.toString());
        this.persons.clear();
        this.persons.addAll(persons);
    }

    @NonNull
    @Override
    //Create new views (invoked by the layout manager)
    public ListPersonsAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Create a new view and initialise it from the layout defined
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_view, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder personViewHolder, int position) {
        personViewHolder.textView.setText(persons.get(position).getFirstName());
    }

    @Override
    public int getItemCount() {
        if (this.persons == null) return 0;
        return persons.size();
    }
}
