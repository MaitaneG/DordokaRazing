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
public class BezeroaSortu extends AppCompatActivity {

    /**
     *
     * Atributoak
     */
    private ImageButton irten;

    /**
     *
     * Layout-a sortzen denean
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bezeroak_layout);
        hasieratu();
    }

    /**
     *
     * Datuak jaso eta layout-eko objetu guztiak hasieratu
     */
    private void hasieratu() {
        /* Botoiak aurkitzen eta aldagaietan gorde */
        irten = findViewById(R.id.buttonIrtenAurrekontua);

        /* Botoiei listenerra jarri */
        irten.setOnClickListener(this::irten);
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