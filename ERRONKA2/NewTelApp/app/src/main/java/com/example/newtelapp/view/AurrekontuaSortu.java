package com.example.newtelapp.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newtelapp.R;
import com.example.newtelapp.model.Aurrekontua;
import com.example.newtelapp.model.Bezeroa;
import com.example.newtelapp.model.Produktua;

import java.util.ArrayList;

/**
 *
 * AurrekontuaSortu Layout-aren klasea
 */
public class AurrekontuaSortu extends AppCompatActivity {

    /**
     *
     * Atributoak
     */
    private ImageButton irtenBotoia;
    private ImageButton gordeBotoia;
    private ImageButton bezeroakBotoia;
    private ImageButton produktuakBotoia;
    private Spinner bezeroSpinner;
    private Spinner produktuSpinner;

    private ArrayList<Bezeroa> bezeroak;
    private ArrayList<Produktua>produktuak;
    /**
     *
     * Layout-a sortzen denean
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aurrekontua_sortu_layout);
        hasieratu();
    }

    /**
     *
     * Datuak jaso eta layout-eko objetu guztiak hasieratu
     */
    private void hasieratu() {
        /* Botoiak aurkitzen eta aldagaietan gorde */
        irtenBotoia = findViewById(R.id.buttonIrtenAurrekontuaSortu);
        gordeBotoia=findViewById(R.id.buttonGordeAurrekontua);
        bezeroakBotoia=findViewById(R.id.buttonBezeroaSortu);
        produktuakBotoia=findViewById(R.id.buttonProduktuaGehitu);
        bezeroSpinner=findViewById(R.id.spinnerBezeroa);
        produktuSpinner=findViewById(R.id.spinnerProduktua);

        /* Botoiei listenerra jarri */
        irtenBotoia.setOnClickListener(this::irten);
        gordeBotoia.setOnClickListener(this::bezeroaSorturaJoan);
        bezeroakBotoia.setOnClickListener(this::bezeroaSorturaJoan);
        produktuakBotoia.setOnClickListener(this::produktuBatGehitu);

        /* ArrayList-ak bete */
        bezeroak=(ArrayList<Bezeroa>) getIntent().getSerializableExtra("bezeroak");
        produktuak=(ArrayList<Produktua>) getIntent().getSerializableExtra("produktuak");


        String[] bezeroIzena = new String[bezeroak.size()];
        for(int i=0;i<bezeroak.size();i++){
            bezeroIzena[i]=bezeroak.get(i).getIzenaAbizena();
        }

        ArrayAdapter adapterB =new ArrayAdapter(this, android.R.layout.simple_spinner_item,bezeroIzena);
        adapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bezeroSpinner.setAdapter(adapterB);

        String[] produktuIzena = new String[produktuak.size()];
        for(int i=0;i<produktuak.size();i++){
            produktuIzena[i]=produktuak.get(i).getIzena();
        }
        ArrayAdapter adapterP =new ArrayAdapter(this, android.R.layout.simple_spinner_item,produktuIzena);
        adapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        produktuSpinner.setAdapter(adapterP);

    }

    private void produktuBatGehitu(View view) {
        Toast.makeText(this,produktuSpinner.getSelectedItemPosition()+"",Toast.LENGTH_SHORT);
    }

    /**
     *
     * Bezeroa Sortu-ra joatea
     *
     * @param view
     */
    private void bezeroaSorturaJoan(View view) {
        Intent myIntent=new Intent(view.getContext(), BezeroaSortu.class);
        ActivityOptions options=ActivityOptions.makeCustomAnimation(this,R.anim.from_right,R.anim.from_right);
        myIntent.putExtra("bezeroak",bezeroak);
        myIntent.putExtra("produktuak",produktuak);
        this.startActivity(myIntent,options.toBundle());
    }

    /**
     *
     * Aurreko layout-era joateko
     * @param view
     */
    private void irten(View view){
        Intent myIntent = new Intent(view.getContext(), AurrekontuaMenua.class);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        this.startActivity(myIntent, options.toBundle());
    }
}