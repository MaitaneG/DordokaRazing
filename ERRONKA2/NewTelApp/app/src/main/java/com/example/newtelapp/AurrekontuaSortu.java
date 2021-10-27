package com.example.newtelapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

/**
 *
 * AurrekontuaSortu Layout-aren klasea
 */
public class AurrekontuaSortu extends AppCompatActivity {

    /**
     *
     * Atributoak
     */
    private ImageButton irten;
    private ImageButton gorde;
    private ImageButton bezeroak;

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
        irten = findViewById(R.id.buttonIrtenAurrekontuaSortu);
        gorde=findViewById(R.id.buttonGordeAurrekontua);
        bezeroak=findViewById(R.id.buttonBezeroaSortu);

        /* Botoiei listenerra jarri */
        irten.setOnClickListener(this::irten);
        gorde.setOnClickListener(this::bezeroaSorturaJoan);
        bezeroak.setOnClickListener(this::bezeroaSorturaJoan);
    }

    /**
     *
     * Bezeroa Sortu-ra joatea
     *
     * @param view
     */
    private void bezeroaSorturaJoan(View view) {
        Intent myIntent=new Intent(view.getContext(),BezeroaSortu.class);
        ActivityOptions options=ActivityOptions.makeCustomAnimation(this,R.anim.from_right,R.anim.from_right);
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