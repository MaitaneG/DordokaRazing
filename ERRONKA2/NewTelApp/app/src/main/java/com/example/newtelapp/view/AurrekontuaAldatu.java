package com.example.newtelapp.view;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
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

import com.example.newtelapp.R;
import com.example.newtelapp.model.Aurrekontua;
import com.example.newtelapp.model.AurrekontuaLerroa;
import com.example.newtelapp.model.Bezeroa;
import com.example.newtelapp.model.Produktua;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * AurrekontuakAldatu-ren Layout-aren klasea
 */
public class AurrekontuaAldatu extends AppCompatActivity {
    /**
     * Atributoak
     **/
    // ImageButton
    private ImageButton irten;
    private ImageButton gorde;
    private ImageButton produktuaGehitu;
    // TextView
    private TextView textViewBezeroaAldatu;
    private TextView prezioaGuztira;
    //EditText
    private EditText kantitatea;
    // Spinner
    private Spinner spinnerProduktuAldatu;
    // ArrayList-ak
    private ArrayList<AurrekontuaLerroa> aurrekontuaLerroa;
    private ArrayList<Produktua> produktuak;
    // Objektu bat
    private Aurrekontua aurrekontua;
    // TableLayout
    private TableLayout taula;


//    // TableRow bakoitzeko izena
//    private String produktuIzena = "";
//    // TableRow bakoitzeko kantitatea
//    private float produktuKantitatea = (float) 0.1;
//    // TableRow bakoitzeko prezioa
//    private float produktuPrezioa = (float) 0.1;
//    // Aurrekontuari izena emateko
//    private String aurrekontuIzena;
//    private int ida;

    /**
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aurrekontuak_aldatu_layout);
        hasieratu(); // Konponenteak hasieratu
    }

    /**
     * Konponente guztiak hasieratzen dira
     */
    private void hasieratu() {
        /** Konponenteak hasieratu **/
        // Botoiak
        irten = findViewById(R.id.buttonIrtenAurrekontuaSortuAurrekontuaAldatu);
        gorde = findViewById(R.id.buttonGordeAurrekontuaAldatu);
        produktuaGehitu = findViewById(R.id.buttonProduktuaGehituAurrekontuaAldatu);
        // TextView
        textViewBezeroaAldatu = findViewById(R.id.textViewBezeroaAldatu);
        prezioaGuztira = findViewById(R.id.textViewPrezioaGuztiraAurrekontuaAldatu);
        // Spinner
        spinnerProduktuAldatu = findViewById(R.id.spinnerProduktuaAurrekontuaAldatu);
        // EditText
        kantitatea = findViewById(R.id.editTextNumberKantitateaAldatu);

        /** Botoiei listerrenak jarri **/
        irten.setOnClickListener(this::irten);
        gorde.setOnClickListener(this::gorde);
        produktuaGehitu.setOnClickListener(this::produktuaGehitu);

        /** Datuak hasieratu **/
        aurrekontuaLerroa = (ArrayList<AurrekontuaLerroa>) getIntent().getSerializableExtra("aurrekontuaLerroak");
        aurrekontua = (Aurrekontua) getIntent().getSerializableExtra("aurrekontua");
        produktuak = (ArrayList<Produktua>) getIntent().getSerializableExtra("produktuak");

        textViewBezeroaAldatu.setText(aurrekontua.getBezeroaIzena());

        /**Spinnerak kargatu**/
        spinnerraKargatu();
        /** Taula sortu eta hasieratu **/
        taulaHasieratu();
    }

    private void spinnerraKargatu() {
        /** Produktuen ArrayList-etik bezeroaren izena hartzen du **/
        String[] produktuIzena = new String[produktuak.size()];
        for (int i = 0; i < produktuak.size(); i++) {
            produktuIzena[i] = produktuak.get(i).getIzena();
        }

        /** Adapter bat sortzen da Produktuen spinner batean jartzeko **/
        ArrayAdapter adapterP = new ArrayAdapter(this, android.R.layout.simple_spinner_item, produktuIzena);
        adapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProduktuAldatu.setAdapter(adapterP);
    }

    /**
     * Taula sortzen du eta zutabeen tituloak hasieratu
     */
    @SuppressLint("ResourceAsColor")
    private void taulaHasieratu() {
        /** Taula sortu **/
        taula = findViewById(R.id.taulaAurrekontuaSortu);

        for (int i = 0; i < aurrekontuaLerroa.size(); i++) {
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
            column1.setTextColor(R.color.black);
            column1.setWidth(px1);
            // Bigarren zutabea
            TextView column2 = new TextView(this);
            column2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            column1.setTextColor(R.color.black);
            column2.setWidth(px23);
            // Hirugarren zutabea
            TextView column3 = new TextView(this);
            column3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            column1.setTextColor(R.color.black);
            column3.setWidth(px23);

            /** Zutabeak betzen du **/
            column1.setText(aurrekontuaLerroa.get(i).getIzenaProduktua());
            column2.setText(aurrekontuaLerroa.get(i).getKantitatea()+"");
            column3.setText(aurrekontuaLerroa.get(i).getPrezioaProduktua()+"");

            /** Zutabeak ilaran sartu **/
            tableRow.addView(column1);
            tableRow.addView(column2);
            tableRow.addView(column3);

            /** Ilara taulan sartzen du **/
            taula.addView(tableRow);

            //prezioaGuztira.setText(Float.parseFloat(prezioaGuztira.getText().toString()) + (produktuak.get(produktuSpinner.getSelectedItemPosition()).getPrezioa() * Float.parseFloat(kantitatea.getText().toString())) + "");

        }
    }

    /**
     * Produktu bat gehitzeko taulara
     *
     * @param view
     */
    private void produktuaGehitu(View view) {

    }

    /**
     * Aurrekontuaren informazioa datu basean gordetzen du
     *
     * @param view
     */
    private void gorde(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Aurrekontua gordetzan")// Dialog-ari titulua jarri
                .setMessage("Ziur zaude aurrekontua gehitu nahi duzula?") // Dialog-aren mezua jarri

                // Baiezko aukera klikatzen bada, aplikazioa itxiko da
                .setPositiveButton("BAI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        if (getIntent().getBooleanExtra("EXIT", true)) {

                        }
                    }
                })

                // Listener huts bat, Ez klikatzen bada ez da aplikazioa itxiko
                .setNegativeButton("EZ", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    /**
     * Atzera joatea nahi duzun galdetzen du
     */
    private void alertAtzera() {
        /** Alert-a sortu eta hasieratu **/
        new AlertDialog.Builder(this)
                .setTitle("Pantaila honetatik irtetzen")// Dialog-ari titulua jarri
                .setMessage("Ziur zaude atzera joan nahi zarela gorde gabe?") // Dialog-aren mezua jarri

                // Baiezko aukera klikatzen bada, bezeroa gordeko da
                .setPositiveButton("BAI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Aurreko layout-era doa
                        Intent myIntent = new Intent(AurrekontuaAldatu.this, AurrekontuaSortu.class);
                        ActivityOptions options = ActivityOptions.makeCustomAnimation(AurrekontuaAldatu.this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
                        AurrekontuaAldatu.this.startActivity(myIntent, options.toBundle());
                    }
                })

                // Listener huts bat, Ez klikatzen bada ez da atzera egingo
                .setNegativeButton("EZ", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    /**
     * Aurreko pantailara doa
     *
     * @param view
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
