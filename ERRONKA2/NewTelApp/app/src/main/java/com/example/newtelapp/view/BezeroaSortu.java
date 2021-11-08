package com.example.newtelapp.view;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newtelapp.R;
import com.example.newtelapp.model.Bezeroa;
import com.example.newtelapp.model.Produktua;
import com.example.newtelapp.view.AurrekontuaSortu;

import java.util.ArrayList;

/**
 * Bigarren Layout-aren klasea
 */
public class BezeroaSortu extends AppCompatActivity {

    /**
     * Atributoak
     */
    // ImageButton
    private ImageButton irtenBotoia;
    private ImageButton gordeBotoia;
    // EditText
    private EditText izenAbizena;
    private EditText mugikorZenbakia;
    private EditText korreoElektronikoa;
    private EditText kalea;
    private EditText hiria;
    private EditText probintzia;
    private EditText kodigoPostala;
    private EditText herrialdea;
    //Switch
    private Switch enpresaDa;
    // ArrayList-a
    private ArrayList<Produktua> produktuak; // Produktuen ArrayList-a
    private ArrayList<Bezeroa> bezeroak; // Bezeroen ArrayList-a

    /**
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bezeroak_layout);
        hasieratu();
    }

    /**
     * Datuak jaso eta layout-eko objetu guztiak hasieratu
     */
    private void hasieratu() {
        /** Botoiak aurkitzen eta aldagaietan gorde **/
        // Botoiak
        irtenBotoia = findViewById(R.id.buttonIrtenAurrekontuaSortu);
        gordeBotoia = findViewById(R.id.buttonGordeBezeroa);
        // EditText
        izenAbizena = findViewById(R.id.editTextIzenaAbizena);
        mugikorZenbakia = findViewById(R.id.editTextMugikorra);
        korreoElektronikoa = findViewById(R.id.editTextKorreoa);
        kalea = findViewById(R.id.editTextKalea);
        hiria = findViewById(R.id.editText_Hiria);
        probintzia = findViewById(R.id.editTextProbintzia);
        kodigoPostala = findViewById(R.id.editTextKodigoPostala);
        herrialdea = findViewById(R.id.editTextHerrialdea);
        // Switch
        enpresaDa = findViewById(R.id.switchEnpresa);

        /** Botoiei listenerra jarri **/
        irtenBotoia.setOnClickListener(this::irten);
        gordeBotoia.setOnClickListener(this::gorde);

        /** ArrayList-ak informazioz bete **/
        bezeroak = (ArrayList<Bezeroa>) getIntent().getSerializableExtra("bezeroak");
        produktuak = (ArrayList<Produktua>) getIntent().getSerializableExtra("produktuak");
    }

    /**
     * Bezeroaren informazioa datu basean gordetzen du
     *
     * @param view
     */
    private void gorde(View view) {
        /** Alert-a sortu eta hasieratu **/
        new AlertDialog.Builder(this)
                .setTitle("Bezeroa gordetzen")// Dialog-ari titulua jarri
                .setMessage("Ziur zaude bezeroa gehitu nahi duzula?") // Dialog-aren mezua jarri

                // Baiezko aukera klikatzen bada, bezeroa gordeko da
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Gako guztiak beteta daudela konprobatzen du
                        if (izenAbizena.getText().toString().trim().equals("") || mugikorZenbakia.getText().toString().trim().equals("") ||
                                korreoElektronikoa.getText().toString().trim().equals("") || kalea.getText().toString().trim().equals("") ||
                                hiria.getText().toString().trim().equals("") || probintzia.getText().toString().trim().equals("") ||
                                kodigoPostala.getText().toString().trim().equals("") || herrialdea.getText().toString().trim().equals("")) {
                            Toast.makeText(view.getContext(), "Gako guztiak bete behar dira", Toast.LENGTH_SHORT).show();

                        } else if (!korreoElektronikoa.getText().toString().trim().contains("@") && !korreoElektronikoa.getText().toString().trim().contains(".")) {
                            Toast.makeText(view.getContext(), "Korreoaren formatua gaizki dago", Toast.LENGTH_SHORT).show();
                            // Informazio guztia beteta badago eta ondo
                        } else {
                            Bezeroa bezeroa = new Bezeroa(izenAbizena.getText().toString(), enpresaDa.isChecked(), mugikorZenbakia.getText().toString().trim(),
                                    korreoElektronikoa.getText().toString().trim(), kalea.getText().toString(), hiria.getText().toString().trim(),
                                    probintzia.getText().toString().trim(), Integer.parseInt(kodigoPostala.getText().toString().trim()),
                                    herrialdea.getText().toString().trim());
                            // Bezeroa datu basean sartzen du
                            Menua.konexioa.insertBezeroak(bezeroa);
                            Toast.makeText(view.getContext(), "Bezeroa behar bezala sortu da", Toast.LENGTH_SHORT).show();
                            // Pantaila honetatik irtetzen da
                            irten(view);
                        }

                    }
                })

                // Listener huts bat, Ez klikatzen bada ez da gordeko
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    /**
     * Aurreko layout-era joateko
     *
     * @param view
     */
    private void irten(View view) {
        /** Alert-a sortu eta hasieratu **/
        new AlertDialog.Builder(this)
                .setTitle("Pantaila honetatik irtetzen")// Dialog-ari titulua jarri
                .setMessage("Ziur zaude atzera joan nahi zarela gorde gabe?") // Dialog-aren mezua jarri

                // Baiezko aukera klikatzen bada, bezeroa gordeko da
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Gakoak husten du
                        izenAbizena.setText("");
                        mugikorZenbakia.setText("");
                        korreoElektronikoa.setText("");
                        kalea.setText("");
                        hiria.setText("");
                        probintzia.setText("");
                        kodigoPostala.setText("");
                        herrialdea.setText("");
                        // Aurreko layout-era doa
                        Intent myIntent = new Intent(view.getContext(), AurrekontuaSortu.class);
                        // Bezeroen eta produktuen ArrayList-a eramaten du
                        myIntent.putExtra("bezeroak", bezeroak);
                        myIntent.putExtra("produktuak", produktuak);
                        ActivityOptions options = ActivityOptions.makeCustomAnimation(view.getContext(), R.anim.from_right, R.anim.from_right); // Animazioa definitzen
                        view.getContext().startActivity(myIntent, options.toBundle());
                    }
                })

                // Listener huts bat, Ez klikatzen bada ez da atzera egingo
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();


    }
}