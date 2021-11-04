package com.example.newtelapp.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newtelapp.R;
import com.example.newtelapp.hariak.Konexioa;
import com.example.newtelapp.model.Aurrekontua;
import com.example.newtelapp.model.Bezeroa;
import com.example.newtelapp.model.Produktua;

import java.io.Serializable;
import java.util.ArrayList;

public class AurrekontuaMenua extends AppCompatActivity implements Serializable {

    /**
     *
     * Atributoak
     */
    private ImageButton aurrekontuaSortu;
    private ImageButton aurrrekontuakIkusi;
    private ImageButton irten;

    private ArrayList<Bezeroa> bezeroak;
    private ArrayList<Aurrekontua> aurrekontuak;
    private ArrayList<Produktua>produktuak;
    /**
     *
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aurrekontu_menu_layout);
        hasieratu();
    }

    private void hasieratu() {
        aurrekontuaSortu=findViewById(R.id.buttonAurrekontuaSortu);
        aurrrekontuakIkusi=findViewById(R.id.buttonErakutsiProduktuak);
        irten=findViewById(R.id.buttonIrten);

        aurrekontuaSortu.setOnClickListener(this::aurrekontuaSorturaJoan);
        aurrrekontuakIkusi.setOnClickListener(this::aurrekontuakIkusiraJoan);
        irten.setOnClickListener(this::irten);

        bezeroak=Menua.konexioa.selectBezeroak();
        //aurrekontuak=Menua.konexioa.selectAurrekontuak();
        produktuak=Menua.konexioa.selectProduktuak();
    }

    private void irten(View view) {
        Intent myIntent = new Intent(view.getContext(), Menua.class);
        // Animazioak definitu
        ActivityOptions options=ActivityOptions.makeCustomAnimation(this,R.anim.from_right, R.anim.from_right);

        // Activity hau itxi eta besteari abisatu
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myIntent.putExtra("EXIT", true);
        this.startActivity(myIntent, options.toBundle());
    }

    private void aurrekontuakIkusiraJoan(View view) {
        Intent myIntent = new Intent(view.getContext(), AurrekontuakIkusi.class);
            myIntent.putExtra("aurrekontuak", aurrekontuak);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        this.startActivity(myIntent, options.toBundle());
    }

    private void aurrekontuaSorturaJoan(View view) {
        Intent myIntent = new Intent(view.getContext(), AurrekontuaSortu.class);
            myIntent.putExtra("bezeroak",bezeroak);
            myIntent.putExtra("produktuak",produktuak);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        this.startActivity(myIntent, options.toBundle());
    }
}
