package com.example.gsbvisiteandroid.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.gsbvisiteandroid.Adapters.RecyclerViewVisiteurAdapter;
import com.example.gsbvisiteandroid.GsonRequest;
import com.example.gsbvisiteandroid.Models.Visiteur;
import com.example.gsbvisiteandroid.Models.Visiteurs;
import com.example.gsbvisiteandroid.VolleyHelper;
import com.example.gsbvisiteandroid.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Visiteur> dataVisiteur;
    private RecyclerViewVisiteurAdapter adapter;
    private ActivityMainBinding bindingMain;

    private final String exempleUrl = "http://192.168.210.6/GSBVisiteAndroid/index.php/visiteurs.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingMain = ActivityMainBinding.inflate(getLayoutInflater());
        View view = bindingMain.getRoot();
        setContentView(view);


        recyclerView = bindingMain.rvVisiteur;
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setFocusable(false);


        setDatas();

        final GsonRequest gsonRequest= new GsonRequest(exempleUrl, Visiteurs.class, null, new Response.Listener<Visiteurs>() {
            @Override
            public void onResponse(Visiteurs visiteurs) {

                for (Visiteur visiteur : visiteurs.getVisiteurs()) {
                    dataVisiteur.add(visiteur);
                    recyclerView.setAdapter(adapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if(volleyError != null) Log.e("MainActivity", volleyError.getMessage());
            }
        });
        VolleyHelper.getInstance(getApplicationContext()).addToRequestQueue(gsonRequest);
        adapter = new RecyclerViewVisiteurAdapter(dataVisiteur);
    }


    private void setDatas() {
        dataVisiteur = new ArrayList<Visiteur>();
    }
}