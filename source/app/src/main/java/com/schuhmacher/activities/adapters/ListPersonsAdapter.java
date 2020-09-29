package com.schuhmacher.activities.adapters;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Adapter for the Persons List
 */
public class ListPersonsAdapter extends RecyclerView.Adapter {

    //TODO : tmp, should be replaced by PersonModels when it will be ok
    private String[] persons;

    public ListPersonsAdapter(String[] persons) {
        this.persons = persons;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
