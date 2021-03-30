package com.example.gsbvisiteandroid.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.TextView;

import com.example.gsbvisiteandroid.Models.Visiteur;
import com.example.gsbvisiteandroid.R;
import com.example.gsbvisiteandroid.databinding.ActivityDetailVisiteurBinding;
import com.example.gsbvisiteandroid.databinding.ActivityMainBinding;

public class DetailVisiteurActivity extends AppCompatActivity {

    private ActivityDetailVisiteurBinding bindingDetailVisiteur;
    private TextView textNom, textPrenom, textDateEmbauche, textMail, textTel, textMatricule;
    private Visiteur visiteur;

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