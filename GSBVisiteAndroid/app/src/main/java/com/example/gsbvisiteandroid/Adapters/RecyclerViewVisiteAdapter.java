package com.example.gsbvisiteandroid.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gsbvisiteandroid.Models.Visite;
import com.example.gsbvisiteandroid.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewVisiteAdapter extends RecyclerView.Adapter<RecyclerViewVisiteAdapter.RecyclerViewHolder> {
    private List<Visite> dataModelVisite;
    public RecyclerViewVisiteAdapter(List<Visite> dataModelVisite) {this.dataModelVisite = dataModelVisite; }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list_item_visite, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewVisiteAdapter.RecyclerViewHolder holder, int position) {
        holder.tvNom.setText(String.valueOf(dataModelVisite.get(position).toString()));
    }

    @Override
    public int getItemCount() {
        return dataModelVisite.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tvNom;

        public RecyclerViewHolder(@NonNull View itemView){
            super(itemView);
            tvNom = itemView.findViewById(R.id.tvVisite);
        }
    }
}
