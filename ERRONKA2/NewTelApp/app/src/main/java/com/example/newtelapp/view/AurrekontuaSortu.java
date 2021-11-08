package com.example.newtelapp.view;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.newtelapp.R;
import com.example.newtelapp.model.Bezeroa;
import com.example.newtelapp.model.Produktua;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

/**
 * AurrekontuaSortu Layout-aren klasea
 */
public class AurrekontuaSortu extends AppCompatActivity {

    /**
     * Atributoak
     */
    // ImageButton
    private ImageButton irtenBotoia;
    private ImageButton gordeBotoia;
    private ImageButton bezeroakBotoia;
    private ImageButton produktuakBotoia;
    // Spinner
    private Spinner bezeroSpinner;
    private Spinner produktuSpinner;
    // ArrayList-ak
    private ArrayList<Bezeroa> bezeroak;
    private ArrayList<Produktua> produktuak;
    // EditText
    private EditText kantitatea;
    // TableLayout
    private TableLayout taula;
    // TextView
    private TextView prezioaGuztira;

    /**
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aurrekontua_sortu_layout);
        hasieratu();
    }

    /**
     * Datuak jaso eta layout-eko objetu guztiak hasieratu
     */
    private void hasieratu() {
        /** Botoiak aurkitzen eta aldagaietan gorde **/
        // Botoiak
        irtenBotoia = findViewById(R.id.buttonIrtenAurrekontuaSortu);
        gordeBotoia = findViewById(R.id.buttonGordeAurrekontua);
        bezeroakBotoia = findViewById(R.id.buttonBezeroaSortu);
        produktuakBotoia = findViewById(R.id.buttonProduktuaGehitu);
        // Spinner
        bezeroSpinner = findViewById(R.id.spinnerBezeroa);
        produktuSpinner = findViewById(R.id.spinnerProduktua);
        // EditText
        kantitatea = findViewById(R.id.editTextNumberKantitatea);
        // TextView
        prezioaGuztira = findViewById(R.id.textViewPrezioaGuztira);

        /** Botoiei listenerra jarri **/
        irtenBotoia.setOnClickListener(this::irten);
        gordeBotoia.setOnClickListener(this::gorde);
        bezeroakBotoia.setOnClickListener(this::bezeroaSorturaJoan);
        produktuakBotoia.setOnClickListener(this::produktuBatGehitu);

        /** ArrayList-ak bete **/
        bezeroak = (ArrayList<Bezeroa>) getIntent().getSerializableExtra("bezeroak");
        produktuak = (ArrayList<Produktua>) getIntent().getSerializableExtra("produktuak");

        /**Spinnerak kargatu**/
        spinnerrakKargatu();

        /** Taula sortu eta hasieratu**/
        taulaHasieratu();
    }

    /**
     * Spinnerrak informazioarekin bete
     */
    private void spinnerrakKargatu() {
        /** Bezeroen ArrayList-etik bezeroaren izena hartzen du **/
        String[] bezeroIzena = new String[bezeroak.size()];
        for (int i = 0; i < bezeroak.size(); i++) {
            bezeroIzena[i] = bezeroak.get(i).getIzenaAbizena();
        }

        /** Adapter bat sortzen da Bezeroaren spinner batean jartzeko **/
        ArrayAdapter adapterB = new ArrayAdapter(this, android.R.layout.simple_spinner_item, bezeroIzena);
        adapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bezeroSpinner.setAdapter(adapterB);

        /** Produktuen ArrayList-etik bezeroaren izena hartzen du **/
        String[] produktuIzena = new String[produktuak.size()];
        for (int i = 0; i < produktuak.size(); i++) {
            produktuIzena[i] = produktuak.get(i).getIzena();
        }

        /** Adapter bat sortzen da Produktuen spinner batean jartzeko **/
        ArrayAdapter adapterP = new ArrayAdapter(this, android.R.layout.simple_spinner_item, produktuIzena);
        adapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        produktuSpinner.setAdapter(adapterP);
    }

    /**
     * Taula sortzen du eta zutabeen tituloak hasieratu
     */
    private void taulaHasieratu() {
        /** Taula sortu **/
        taula = findViewById(R.id.taula);
    }

    /**
     * Produktu bat bere kantitatearekin gehitzeko
     *
     * @param view
     */
    private void produktuBatGehitu(View view) {
        /** Ilara bat sortzen du **/
        TableRow tableRow = new TableRow(this);

        /** Hiru zutabe sortzen du **/
        // Zutabeen zabalera definitzeko (dp-tik pixeletara pasatu)
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int px1 = Math.round(115 * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        int px23 = Math.round(70 * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));

        // Lehenengo zutabea
        TextView column1 = new TextView(this);
        column1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        //column1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.taula_row));
        column1.setWidth(px1);
        // Bigarren zutabea
        TextView column2 = new TextView(this);
        column2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        //column2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.taula_row));
        column2.setWidth(px23);
        // Hirugarren zutabea
        TextView column3 = new TextView(this);
        column3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        //column3.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.taula_row));
        column3.setWidth(px23);

        /** Zutabeak betzen du **/
        //column1.setText(produktuak.get(produktuSpinner.getSelectedItemPosition()).getIzena());
        column2.setText(kantitatea.getText().toString());
        //column3.setText(produktuak.get(produktuSpinner.getSelectedItemPosition()).getPrezioa()+"");

        /** Zutabeak ilaran sartu **/
        tableRow.addView(column1);
        tableRow.addView(column2);
        tableRow.addView(column3);

        /** Ilara taulan sartzen du **/
        taula.addView(tableRow);

        /** Kantitatea gakoa hustu**/
        kantitatea.setText("");

        //Toast.makeText(this, produktuSpinner.getSelectedItemPosition() + "", Toast.LENGTH_SHORT);
    }

    /**
     * Bezeroa Sortu-ra joatea
     *
     * @param view
     */
    private void bezeroaSorturaJoan(View view) {
        Intent myIntent = new Intent(AurrekontuaSortu.this, BezeroaSortu.class);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(AurrekontuaSortu.this, R.anim.from_right, R.anim.from_right);
        /** Bezeroen eta produktuen ArrayList-ak eramaten du **/
        myIntent.putExtra("bezeroak", bezeroak);
        myIntent.putExtra("produktuak", produktuak);
        this.startActivity(myIntent, options.toBundle());
    }

    private void gorde(View view) {
        /** Alert-a sortu eta hasieratu **/
        new AlertDialog.Builder(this)
                .setTitle("Aurrekontua gordetzan")// Dialog-ari titulua jarri
                .setMessage("Ziur zaude aurrekontua gehitu nahi duzula?") // Dialog-aren mezua jarri

                // Baiezko aukera klikatzen bada, aplikazioa itxiko da
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        if (getIntent().getBooleanExtra("EXIT", true)) {
                            // Aqui todo el codigo

                        }
                    }
                })

                // Listener huts bat, Ez klikatzen bada ez da aplikazioa itxiko
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    /**
     * Atzera joateko alert mezua
     */
    public void alertAtzera() {
        /** Alert-a sortu eta hasieratu **/
        new AlertDialog.Builder(this)
                .setTitle("Pantaila honetatik irtetzen")// Dialog-ari titulua jarri
                .setMessage("Ziur zaude atzera joan nahi zarela gorde gabe?") // Dialog-aren mezua jarri

                // Baiezko aukera klikatzen bada, aplikazioa itxiko da
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        if (getIntent().getBooleanExtra("EXIT", true)) {
                            Intent myIntent = new Intent(AurrekontuaSortu.this, AurrekontuaMenua.class);
                            ActivityOptions options = ActivityOptions.makeCustomAnimation(getBaseContext(), R.anim.from_right, R.anim.from_right); // Animazioa definitzen
                            AurrekontuaSortu.this.startActivity(myIntent, options.toBundle());
                        }
                    }
                })

                // Listener huts bat, Ez klikatzen bada ez da aplikazioa itxiko
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    /**
     * Aurreko layout-era joateko
     */
    private void irten(View view) {
        alertAtzera();
    }

    /**
     * Atzera joateko botoia klikatzean
     */
    @Override
    public void onBackPressed() {
        alertAtzera();
    }
}