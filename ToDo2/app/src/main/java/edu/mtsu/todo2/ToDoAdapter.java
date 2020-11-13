package edu.mtsu.todo2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ToDoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> items;

    public ToDoAdapter() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ToDoViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_todo, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ToDoViewHolder) holder).checkBox.setText(items.get(position));
        ((ToDoViewHolder) holder).checkBox.setChecked(false);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static private class ToDoViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;

        public ToDoViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
}
