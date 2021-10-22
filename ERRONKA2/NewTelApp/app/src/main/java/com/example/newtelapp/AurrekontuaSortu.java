package com.example.newtelapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

/**
 *
 * Bigarren Layout-aren klasea
 */
public class AurrekontuaSortu extends AppCompatActivity {

    /**
     *
     * Atributoak
     */
    private ImageButton irten;
    private ImageButton bezeroaSortu;

    /**
     *
     * Layout-a sortzen denean
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aurrekontua_layout);
        hasieratu();
    }

    /**
     *
     * Datuak jaso eta layout-eko objetu guztiak hasieratu
     */
    private void hasieratu() {
        /* Botoiak aurkitzen eta aldagaietan gorde */
        irten = findViewById(R.id.button_irten_aurrekontua);
        bezeroaSortu=findViewById(R.id.button_bezeroa_sortu);

        /* Botoiei listenerra jarri */
        irten.setOnClickListener(this::irten);
        bezeroaSortu.setOnClickListener(this::bezeroaSorturaJoan);
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
        Intent myIntent = new Intent(view.getContext(), Menua.class);
        // Animazioak definitu
        ActivityOptions options=ActivityOptions.makeCustomAnimation(this,R.anim.from_right, R.anim.from_right);

        // Activity hau itxi eta besteari abisatu
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myIntent.putExtra("EXIT", true);
        this.startActivity(myIntent, options.toBundle());
    }
}