package com.example.gsbvisiteandroid.Adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gsbvisiteandroid.R;
import com.example.gsbvisiteandroid.Models.Visiteurs;
import com.example.gsbvisiteandroid.Models.Visiteur;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewVisiteurAdapter extends RecyclerView.Adapter<RecyclerViewVisiteurAdapter.RecyclerViewHolder>  {
    private List<Visiteur> dataModelVisiteur;
    public RecyclerViewVisiteurAdapter(List<Visiteur> dataModelVisiteur) {this.dataModelVisiteur = dataModelVisiteur; }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_list_item, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewVisiteurAdapter.RecyclerViewHolder holder, int position) {
        holder.tvNom.setText(String.valueOf(dataModelVisiteur.get(position).toString()));
    }

    @Override
    public int getItemCount() {
        return dataModelVisiteur.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tvNom;

        public RecyclerViewHolder(@NonNull View itemView){
            super(itemView);
            tvNom = itemView.findViewById(R.id.tvVisiteur);
        }
    }
}