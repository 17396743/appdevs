package com.example.appdevs.view.ui.adapters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.appdevs.R;

public class PersonalRecyclerViewAdapter extends RecyclerView.Adapter<PersonalRecyclerViewAdapter.HomeHolder> {


    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class HomeHolder extends RecyclerView.ViewHolder{

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}