package com.example.newtelapp.view;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newtelapp.hariak.Konexioa;
import com.example.newtelapp.R;
import com.example.newtelapp.model.Aurrekontua;
import com.example.newtelapp.model.Bezeroa;
import com.example.newtelapp.model.Produktua;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Lehengo Layout-aren klasea
 */
public class Menua extends AppCompatActivity implements Serializable {

    /**
     * Atributoak
     */
    private ImageButton irten_botoia;
    private ImageButton erakutsi_produktuak_botoia;
    private ImageButton aurrekontua_botoia;

    /**
     * Postgres datu baseko informazioa
     */

    private ArrayList<Produktua> produktuak; // Produktuen ArrayList-a
    public static Konexioa konexioa;

    /**
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        hasieratu();
    }

    /**
     * Layout-eko objetu guztiak hasieratu
     */
    private void hasieratu() {
        /* Botoiak aurkitzen eta aldagaietan gorde */
        erakutsi_produktuak_botoia = findViewById(R.id.buttonErakutsiProduktuak);
        aurrekontua_botoia = findViewById(R.id.buttonAurrekontuaSortu);
        irten_botoia = findViewById(R.id.buttonIrten);
        produktuak = new ArrayList<>();

        /* Botoiei listenerra jarri */
        erakutsi_produktuak_botoia.setOnClickListener(this::produktuakErakutsiraJoan);
        aurrekontua_botoia.setOnClickListener(this::aurrekonturaJoan);
        irten_botoia.setOnClickListener(this::itxi);

        konexioa = new Konexioa();
        produktuak = konexioa.selectProduktuak();
    }

    /**
     * Produktuak Erakutsi-ra joatea
     *
     * @param view
     */
    private void produktuakErakutsiraJoan(View view) {
        Intent myIntent = new Intent(view.getContext(), ProduktuakErakutsi.class);
        myIntent.putExtra("produktuak", produktuak); // Produktuen arrayList-a eramaten du
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        this.startActivity(myIntent, options.toBundle());
    }

    /**
     * Aurrekontua Sortu-ra joatea
     *
     * @param view
     */
    private void aurrekonturaJoan(View view) {
        Intent myIntent = new Intent(view.getContext(), AurrekontuaMenua.class);
        myIntent.putExtra("produktuak", produktuak); // Produktuen arrayList-a eramaten du
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right);
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

    /**
     * Alerta agertzen da, galdetzen irten nahi den ala ez
     */
    private void alert() {
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

                // Listener huts bat, Ez klikatzen bada ez da aplikazioa itxiko
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    /**
     * Mobilaren azterako botoia zakatzean
     */
    @Override
    public void onBackPressed() {
        alert();
    }
}
