package com.example.gsbvisiteandroid.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.gsbvisiteandroid.Adapters.RecyclerViewVisiteAdapter;
import com.example.gsbvisiteandroid.GsonRequest;
import com.example.gsbvisiteandroid.Models.Visite;
import com.example.gsbvisiteandroid.Models.Visites;
import com.example.gsbvisiteandroid.Models.Visiteur;
import com.example.gsbvisiteandroid.Models.Visiteurs;
import com.example.gsbvisiteandroid.VolleyHelper;
import com.example.gsbvisiteandroid.databinding.ActivityDetailVisiteurBinding;

import java.util.ArrayList;
import java.util.List;

public class DetailVisiteurActivity extends AppCompatActivity {

    private ActivityDetailVisiteurBinding bindingDetailVisiteur;
    private TextView textNom, textPrenom, textDateEmbauche, textMail, textTel, textMatricule;
    private Visiteur visiteur;
    private RecyclerView recyclerView;
    private List<Visite> dataVisite;
    private RecyclerViewVisiteAdapter adapter = new RecyclerViewVisiteAdapter(dataVisite);

    private String exempleUrl = "http://192.168.210.6/GSBVisiteAndroid/index.php/visiteurs/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingDetailVisiteur = ActivityDetailVisiteurBinding.inflate(getLayoutInflater());
        View mainView = bindingDetailVisiteur.getRoot();
        setContentView(mainView);

        Intent intentVisiteur = getIntent();
        visiteur = (Visiteur)intentVisiteur.getSerializableExtra("VISITEUR_DETAIL");
        Init();

        AfficherDonnees();

        recyclerView = bindingDetailVisiteur.rvVisiteDetail;
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setFocusable(false);

        setDatas();
/*
        recyclerView.addOnItemTouchListener(new RecyclerTouchVisiteurListener(this, recyclerView, ((view, position) -> {
            Visite maVisite = dataVisite.get(position);
            Intent detailVisiteur = new Intent(getApplicationContext(), DetailVisiteurActivity.class);
            detailVisiteur.putExtra("VISITEUR_DETAIL", monVisiteur);
            startActivity(detailVisiteur);
        })));
*/
        exempleUrl += String.valueOf(visiteur.getId()) + ".json";
        final GsonRequest gsonRequest= new GsonRequest(exempleUrl, Visiteurs.class, null, new Response.Listener<Visiteurs>() {
            @Override
            public void onResponse(Visiteurs visiteurs) {
                adapter = new RecyclerViewVisiteAdapter(visiteurs.getVisiteur().getVisites());
                recyclerView.setAdapter(adapter);
                /*for (Visite visite : visites.getVisites()) {
                    dataVisite.add(visite);
                    recyclerView.setAdapter(adapter);
                }*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if(volleyError != null) Log.e("DetailVisiteurActivity", volleyError.getMessage());
            }
        });
        VolleyHelper.getInstance(getApplicationContext()).addToRequestQueue(gsonRequest);
    }

    private void setDatas() {
        dataVisite = new ArrayList<Visite>();
    }

    private void Init() {
        textNom = bindingDetailVisiteur.textViewNomDetail;
        textPrenom = bindingDetailVisiteur.textViewPrenomDetail;
        textDateEmbauche = bindingDetailVisiteur.textViewDateEmbDetail;
        textMail = bindingDetailVisiteur.textViewMailDetail;
        textTel = bindingDetailVisiteur.textViewTelDetail;
        textMatricule = bindingDetailVisiteur.textViewMatriculeDetail;
    }

    private void AfficherDonnees() {
        textNom.setText(visiteur.getNom());
        textPrenom.setText(visiteur.getPrenom());
        textDateEmbauche.setText(visiteur.getDateEmbauche().substring(0,9));
        textMail.setText(visiteur.getMail());
        textTel.setText(visiteur.getTel());
        textMatricule.setText(visiteur.getMatricule());
    }
}