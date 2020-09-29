package com.schuhmacher.activities.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    public PersonViewHolder(@NonNull View itemView, TextView textView) {
        super(itemView);
        this.textView = textView;
    }
}
