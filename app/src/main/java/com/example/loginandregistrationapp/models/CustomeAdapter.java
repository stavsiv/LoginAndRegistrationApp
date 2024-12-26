package com.example.loginandregistrationapp.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandregistrationapp.R;

import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

    private final ArrayList<DataModelCharacter> dataSet;
    private final OnItemClickListener listener;

    public CustomeAdapter(ArrayList<DataModelCharacter> dataSet, OnItemClickListener listener) {
        this.dataSet = dataSet;
        this.listener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewDescription;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.characterName);
            this.textViewDescription = itemView.findViewById(R.id.description);
            this.imageView = itemView.findViewById(R.id.imageView);
        }

        public void bind(DataModelCharacter character) {
            textViewName.setText(character.getName());
            textViewDescription.setText(character.getDescription());
            imageView.setImageResource(character.getImage());
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_character, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataModelCharacter character = dataSet.get(position);
        holder.bind(character);

        holder.itemView.setOnClickListener(v -> listener.onItemClick(character));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
    public interface OnItemClickListener {
        void onItemClick(DataModelCharacter character);
    }
}
