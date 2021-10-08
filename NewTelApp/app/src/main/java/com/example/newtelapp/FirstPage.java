package com.example.newtelapp;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Lehengo Layout-aren klasea
 */
public class FirstPage extends AppCompatActivity {

    /**
     * Atributoak
     */
    private ImageButton irten_botoia;
    private ImageButton erakutsi_produktuak_botoia;

    /**
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        hasieratu();
    }

    /**
     * Layout-eko objetu guztiak hasieratu
     */
    private void hasieratu() {
        /* Botoiak aurkitzen eta aldagaietan gorde */
        erakutsi_produktuak_botoia = findViewById(R.id.button_erakutsi_produktuak);
        irten_botoia = findViewById(R.id.button_irten);

        /* Botoiei listenerra jarri */
        erakutsi_produktuak_botoia.setOnClickListener(this::bestePantilaraJoan);
        irten_botoia.setOnClickListener(this::itxi);
    }

    /**
     * Bigarren layout-era joatea
     *
     * @param view
     */
    private void bestePantilaraJoan(View view) {
        Intent myIntent = new Intent(view.getContext(), SecondPage.class);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        this.startActivity(myIntent, options.toBundle());
    }

    /**
     * Aplikazioa guztiz itxi nahi denean
     *
     * @param view
     */
    private void itxi(View view) {
        alert();
    }

    public void alert(){
        new AlertDialog.Builder(this)
                .setTitle("Aplikazioa ixten ")// Dialog-ari titulua jarri
                .setMessage("Aplikazioa itxi nahi duzu?") // Dialog-aren mezua jarri

                // Baiezko aukera klikatzen bada, aplikazioa itxiko da
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        if (getIntent().getBooleanExtra("EXIT", true)) {
                            finish();
                            System.exit(0);
                        }
                    }
                })

                // Listener juts bat, Ez klikatzen bada ez da aplikazioa itxiko
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void onBackPressed() {
        alert();
    }
}