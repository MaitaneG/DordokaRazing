package com.example.newtelapp.view;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newtelapp.R;
import com.example.newtelapp.model.Bezeroa;
import com.example.newtelapp.model.Produktua;

import java.util.ArrayList;

/**
 * BezeroaSortu Layout-aren klasea
 */
public class BezeroaSortu extends AppCompatActivity {

    /**
     * Atributoak
     */
    // ImageButton
    private ImageButton irtenBotoia;
    private ImageButton gordeBotoia;
    private ImageButton borratu;
    // EditText
    private EditText izenAbizena;
    private EditText mugikorZenbakia;
    private EditText korreoElektronikoa;
    private EditText kalea;
    private EditText hiria;
    private EditText kodigoPostala;
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
        borratu = findViewById(R.id.imageButtonBorratu);
        // EditText
        izenAbizena = findViewById(R.id.editTextIzenaAbizena);
        mugikorZenbakia = findViewById(R.id.editTextMugikorra);
        korreoElektronikoa = findViewById(R.id.editTextKorreoa);
        kalea = findViewById(R.id.editTextKalea);
        hiria = findViewById(R.id.editText_Hiria);
        kodigoPostala = findViewById(R.id.editTextKodigoPostala);
        // Switch
        enpresaDa = findViewById(R.id.switchEnpresa);

        /** Botoiei listenerra jarri **/
        irtenBotoia.setOnClickListener(this::irten);
        gordeBotoia.setOnClickListener(this::gorde);
        borratu.setOnClickListener(this::borratu);

        /** ArrayList-ak informazioz bete **/
        bezeroak = (ArrayList<Bezeroa>) getIntent().getSerializableExtra("bezeroak");
        produktuak = (ArrayList<Produktua>) getIntent().getSerializableExtra("produktuak");
    }

    private void garbitu() {
        izenAbizena.setText("");
        mugikorZenbakia.setText("");
        korreoElektronikoa.setText("");
        kalea.setText("");
        hiria.setText("");
        kodigoPostala.setText("");
    }

    private void borratu(View view) {
        garbitu();
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
                .setPositiveButton("BAI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        /** Bezeroa gordetzen du **/
                        // Gako guztiak beteta daudela konprobatzen du
                        if (izenAbizena.getText().toString().trim().equals("") || mugikorZenbakia.getText().toString().trim().equals("") ||
                                korreoElektronikoa.getText().toString().trim().equals("") || kalea.getText().toString().trim().equals("") ||
                                hiria.getText().toString().trim().equals("") ||
                                kodigoPostala.getText().toString().trim().equals("")) {

                            Toast.makeText(view.getContext(), "Gako guztiak bete behar dira", Toast.LENGTH_SHORT).show();
                        // Korreo elektronikoa ez badago ondo
                        } else if (!korreoElektronikoa.getText().toString().trim().contains("@") || !korreoElektronikoa.getText().toString().trim().contains(".")) {
                            Toast.makeText(view.getContext(), "Korreoaren formatua gaizki dago", Toast.LENGTH_SHORT).show();
                            // Informazio guztia beteta badago eta ondo
                        } else {
                            Bezeroa bezeroa = new Bezeroa(/*El id no lo uso*/1, izenAbizena.getText().toString(), enpresaDa.isChecked(), mugikorZenbakia.getText().toString().trim(),
                                    korreoElektronikoa.getText().toString().trim(), kalea.getText().toString(), hiria.getText().toString().trim(), Integer.parseInt(kodigoPostala.getText().toString().trim()));
                            // Bezeroa datu basean sartzen du
                            Menua.konexioa.insertBezeroak(bezeroa);
                            Toast.makeText(view.getContext(), "Bezeroa behar bezala sortu da", Toast.LENGTH_SHORT).show();
                            // Pantaila honetatik irtetzen da

                            garbitu();
                            irtenAlertGabe();

                        }

                    }
                })

                // Listener huts bat, Ez klikatzen bada ez da gordeko
                .setNegativeButton("EZ", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    /**
     * Aurreko layout-era joateko
     */
    private void alertAtzera() {
        /** Alert-a sortu eta hasieratu **/
        new AlertDialog.Builder(this)
                .setTitle("Pantaila honetatik irtetzen")// Dialog-ari titulua jarri
                .setMessage("Ziur zaude atzera joan nahi zarela gorde gabe?") // Dialog-aren mezua jarri

                // Baiezko aukera klikatzen bada, bezeroa gordeko da
                .setPositiveButton("BAI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Gakoak husten du
                        garbitu();

                        // Aurreko layout-era doa
                        Intent myIntent = new Intent(BezeroaSortu.this, AurrekontuaSortu.class);
                        // Bezeroen eta produktuen ArrayList-a eramaten du
                        myIntent.putExtra("bezeroak", bezeroak);
                        myIntent.putExtra("produktuak", produktuak);
                        ActivityOptions options = ActivityOptions.makeCustomAnimation(BezeroaSortu.this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
                        BezeroaSortu.this.startActivity(myIntent, options.toBundle());
                    }
                })

                // Listener huts bat, Ez klikatzen bada ez da atzera egingo
                .setNegativeButton("EZ", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    /**
     * Aurreko layout-era joateko
     */
    private void irten(View view) {
        alertAtzera();
    }

    private void irtenAlertGabe(){
        // Gakoak husten du
        garbitu();

        // Aurreko layout-era doa
        Intent myIntent = new Intent(BezeroaSortu.this, AurrekontuaMenua.class);
        // Bezeroen eta produktuen ArrayList-a eramaten du
        myIntent.putExtra("bezeroak", bezeroak);
        myIntent.putExtra("produktuak", produktuak);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(BezeroaSortu.this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        BezeroaSortu.this.startActivity(myIntent, options.toBundle());
    }

    /**
     * Atzera joateko botoia klikatzean
     */
    @Override
    public void onBackPressed() {
        alertAtzera();
    }
}