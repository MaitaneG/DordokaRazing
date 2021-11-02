package com.example.newtelapp.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newtelapp.R;
import com.example.newtelapp.view.AurrekontuaSortu;

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
        irten = findViewById(R.id.buttonIrtenAurrekontuaSortu);

        /* Botoiei listenerra jarri */
        irten.setOnClickListener(this::irten);
    }

    /**
     *
     * Aurreko layout-era joateko
     * @param view
     */
    private void irten(View view){
        Intent myIntent = new Intent(view.getContext(), AurrekontuaSortu.class);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        this.startActivity(myIntent, options.toBundle());
    }
}