package com.example.newtelapp.view;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    // Spinner
    private Spinner spinnerProdukttuAldatu;
    // ArrayList-ak
    private ArrayList<Bezeroa> bezeroak;
    private ArrayList<Produktua> produktuak;
    private ArrayList<Aurrekontua> aurrekontuak;
    // TableLayout
    private TableLayout taula;
    // SemaforoaInsertAurrekontua
    private Semaphore semaforoaInsertAurrekontua;
    // TableRow bakoitzeko izena
    private String produktuIzena = "";
    // TableRow bakoitzeko kantitatea
    private float produktuKantitatea = (float) 0.1;
    // TableRow bakoitzeko prezioa
    private float produktuPrezioa = (float) 0.1;
    // Aurrkontuari izena emateko
    private String aurrekontuIzena;
    private int ida;

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
        spinnerProdukttuAldatu = findViewById(R.id.spinnerProduktuaAurrekontuaAldatu);

        /** Botoiei listerrenak jarri **/
        irten.setOnClickListener(this::irten);
        gorde.setOnClickListener(this::gorde);
        produktuaGehitu.setOnClickListener(this::produktuaGehitu);
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

                            /** Datuen lehengo ilara hartzen du **/
                            View child = taula.getChildAt(1);

                            /** Hutsik badago **/
                            if (child == null) {
                                Toast.makeText(AurrekontuaAldatu.this, "Ez dago daturik taulan. Datuak sartu behar dituzu gorde ahal izateko", Toast.LENGTH_LONG).show();
                                /** Datuak badaude **/
                            } else {
                                /** Sortzen du aurrekontuaren izena **/
                                aurrekontuIzena = "";
                                ida = 0;
                                for (int i = 0; i < aurrekontuak.size(); i++) {
                                    ida = aurrekontuak.get(i).getId();
                                }
                                aurrekontuIzena = "SM000" + ida;
                                Toast.makeText(AurrekontuaAldatu.this, aurrekontuIzena, Toast.LENGTH_SHORT).show();

                                Date data = new Date(2002, 11, 28);
                                /** Aurrekontu objetu bat sortzen du **/
                                //Aurrekontua aurrekontua = new Aurrekontua(1, aurrekontuIzena, bezeroak.get(bezeroSpinner.getSelectedItemPosition()).getId(), bezeroak.get(bezeroSpinner.getSelectedItemPosition()).getIzenaAbizena(), "draft", Float.parseFloat(prezioaGuztira.getText().toString()), data);

                                /** Aurrekontuak gehitzeko haria **/
                                Thread insertAurrekontuak = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            // Semaforoa okupatzen du
                                            semaforoaInsertAurrekontua.acquire();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        // Aurrekontua gehitzen du
                                        //Menua.konexioa.insertAurrekontua(aurrekontua);
                                        // Semaforoa libre lagatzen du
                                        semaforoaInsertAurrekontua.release();
                                    }
                                });
                                insertAurrekontuak.setPriority(Thread.MAX_PRIORITY);
                                insertAurrekontuak.start();

                                /** AurrekontuLerroa gehitzeko haria **/
                                Thread insertAurrekontuaLerroa = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        /** Ilara bakoitzeko **/
                                        for (int i = 1; i < taula.getChildCount(); i++) {
                                            /** Sortzen du ilara bat **/
                                            View row = taula.getChildAt(i);
                                            if (row instanceof TableRow) {
                                                TableRow rowC = (TableRow) row;
                                                /** Zutabe bakoitzeko **/
                                                for (int j = 0; j < rowC.getChildCount(); j++) {
                                                    /** Sortzen du zutabe bat **/
                                                    TextView texto = (TextView) rowC.getChildAt(j);
                                                    /** Datuen lehenengo zutabea bada **/
                                                    if (j == 0) {
                                                        produktuIzena = texto.getText().toString();
                                                        /** Datuen bigarren zutabea bada **/
                                                    } else if (j == 1) {
                                                        produktuKantitatea = Float.parseFloat(texto.getText().toString());
                                                        /** Datuen hirugarren zutabea bada **/
                                                    } else {
                                                        produktuPrezioa = Float.parseFloat(texto.getText().toString());

                                                        for (int h = 0; h < produktuak.size(); h++) {

                                                            if (produktuak.get(h).getIzena().equals(produktuIzena)) {
                                                                AurrekontuaLerroa aurrekontuaLerroa = new AurrekontuaLerroa(1, ida + 1, produktuak.get(h).getId(), produktuIzena, produktuPrezioa, produktuKantitatea, (produktuak.get(h).getPrezioa() * produktuKantitatea));
                                                                // Aurrekontu lerroa sortzen du
                                                                Menua.konexioa.insertAurrekontuaLerroa(aurrekontuaLerroa);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                });
                                insertAurrekontuaLerroa.start();
                            }
                            taula = findViewById(R.id.taulaAurrekontuaAldatu); // Esto no lo hace
                            prezioaGuztira.setText("");
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
