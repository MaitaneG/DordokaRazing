package com.example.newtelapp.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newtelapp.R;
import com.example.newtelapp.model.Bezeroa;
import com.example.newtelapp.model.Produktua;
import com.example.newtelapp.view.AurrekontuaSortu;

import java.util.ArrayList;

/**
 *
 * Bigarren Layout-aren klasea
 */
public class BezeroaSortu extends AppCompatActivity {

    /**
     *
     * Atributoak
     */
    private ImageButton irtenBotoia;
    private ImageButton gordeBotoia;
    private EditText izenAbizena;
    private EditText mugikorZenbakia;
    private EditText korreoElektronikoa;
    private EditText kalea;
    private EditText hiria;
    private EditText probintzia;
    private EditText kodigoPostala;
    private EditText herrialdea;

    private ArrayList<Produktua> produktuak; // Produktuen ArrayList-a
    private ArrayList<Bezeroa>bezeroak;
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
        // Botoiak
        irtenBotoia = findViewById(R.id.buttonIrtenAurrekontuaSortu);
        gordeBotoia=findViewById(R.id.buttonGordeBezeroa);
        // EditText
        izenAbizena=findViewById(R.id.editTextIzenaAbizena);
        mugikorZenbakia=findViewById(R.id.editTextMugikorra);
        korreoElektronikoa=findViewById(R.id.editTextKorreoa);
        kalea=findViewById(R.id.editTextKalea);
        hiria=findViewById(R.id.editText_Hiria);
        probintzia=findViewById(R.id.editTextProbintzia);
        kodigoPostala=findViewById(R.id.editTextKodigoPostala);
        herrialdea=findViewById(R.id.editTextHerrialdea);

        /* Botoiei listenerra jarri */
        irtenBotoia.setOnClickListener(this::irten);
        gordeBotoia.setOnClickListener(this::gorde);

        bezeroak=(ArrayList<Bezeroa>) getIntent().getSerializableExtra("bezeroak");
        produktuak=(ArrayList<Produktua>) getIntent().getSerializableExtra("produktuak");
    }

    private void gorde(View view) {
        if(izenAbizena.getText().toString().trim().equals("") || mugikorZenbakia.getText().toString().trim().equals("") ||
                korreoElektronikoa.getText().toString().trim().equals("") || kalea.getText().toString().trim().equals("") ||
                hiria.getText().toString().trim().equals("") || probintzia.getText().toString().trim().equals("") ||
                kodigoPostala.getText().toString().trim().equals("") || herrialdea.getText().toString().trim().equals("")){
            Toast.makeText(this,"Gako guztiak bete behar dira",Toast.LENGTH_LONG).show();
        }else{
            Bezeroa bezeroa=new Bezeroa(izenAbizena.getText().toString(), mugikorZenbakia.getText().toString().trim(),
                    korreoElektronikoa.getText().toString().trim(), kalea.getText().toString(), hiria.getText().toString().trim(),
                    probintzia.getText().toString().trim(),Integer.parseInt(kodigoPostala.getText().toString().trim()),
                    herrialdea.getText().toString().trim());

            Menua.konexioa.insertBezeroak(bezeroa);
            Toast.makeText(this, "Bezeroa behar bezala sortu da",Toast.LENGTH_SHORT).show();
            irten(view);
        }
    }

    /**
     *
     * Aurreko layout-era joateko
     * @param view
     */
    private void irten(View view){
        izenAbizena.setText("");
        mugikorZenbakia.setText("");
        korreoElektronikoa.setText("");
        kalea.setText("");
        hiria.setText("");
        probintzia.setText("");
        kodigoPostala.setText("");
        herrialdea.setText("");
        Intent myIntent = new Intent(view.getContext(), AurrekontuaSortu.class);
            myIntent.putExtra("bezeroak",bezeroak);
            myIntent.putExtra("produktuak",produktuak);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        this.startActivity(myIntent, options.toBundle());
    }
}