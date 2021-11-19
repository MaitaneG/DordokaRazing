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
import android.widget.Button;
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
    private ArrayList<Aurrekontua> aurrekontuak;
    // EditText
    private EditText kantitatea;
    // TableLayout
    private TableLayout taula;
    // TextView
    private TextView prezioaGuztira;
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
        prezioaGuztira = findViewById(R.id.textViewPrezioaGuztiraInformazioaAurrekontuaSortu);

        /** Botoiei listenerra jarri **/
        irtenBotoia.setOnClickListener(this::irten);
        gordeBotoia.setOnClickListener(this::gorde);
        bezeroakBotoia.setOnClickListener(this::bezeroaSorturaJoan);
        produktuakBotoia.setOnClickListener(this::produktuBatGehitu);

        /** ArrayList-ak bete **/
        bezeroak = (ArrayList<Bezeroa>) getIntent().getSerializableExtra("bezeroak");
        produktuak = (ArrayList<Produktua>) getIntent().getSerializableExtra("produktuak");
        aurrekontuak = (ArrayList<Aurrekontua>) getIntent().getSerializableExtra("aurrekontuak");

        /** Semaforoa hasieratu **/
        semaforoaInsertAurrekontua = new Semaphore(1, true);

        /** Spinnerak kargatu **/
        spinnerrakKargatu();

        /** Taula sortu eta hasieratu **/
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
        adapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        produktuSpinner.setAdapter(adapterP);
    }

    /**
     * Taula sortzen du eta zutabeen tituloak hasieratu
     */
    private void taulaHasieratu() {
        /** Taula sortu **/
        taula = findViewById(R.id.taulaAurrekontuaSortu);
    }

    /**
     * Produktu bat bere kantitatearekin gehitzeko
     *
     * @param view
     */
    private void produktuBatGehitu(View view) {

        // Kantitatea hutsik badago
        if (kantitatea.getText().toString().equals("")) {
            Toast.makeText(this, "Produktuen kantitatea sartu behar duzu", Toast.LENGTH_SHORT).show();
            // Knatitatea ez badago hutsik
        } else {
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
            column1.setTextColor(getResources().getColor(R.color.black));
            column1.setTextSize(13);
            column1.setWidth(px1);
            // Bigarren zutabea
            TextView column2 = new TextView(this);
            column2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            column2.setTextColor(getResources().getColor(R.color.black));
            column2.setTextSize(13);
            column2.setWidth(px23);
            // Hirugarren zutabea
            TextView column3 = new TextView(this);
            column3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            column3.setTextColor(getResources().getColor(R.color.black));
            column3.setTextSize(13);
            column3.setWidth(px23);
            // Hirugarren zutabea
            Button borratu = new Button(this);
            borratu.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            borratu.setWidth(px23);

            /** Zutabeak betzen du **/
            column1.setText(produktuak.get(produktuSpinner.getSelectedItemPosition()).getIzena());
            column2.setText(kantitatea.getText().toString());
            column3.setText(produktuak.get(produktuSpinner.getSelectedItemPosition()).getPrezioa() + "");

            /** Zutabeak ilaran sartu **/
            tableRow.addView(column1);
            tableRow.addView(column2);
            tableRow.addView(column3);

            /** Ilara taulan sartzen du **/
            taula.addView(tableRow);

            prezioaGuztira.setText(Float.parseFloat(prezioaGuztira.getText().toString()) + (produktuak.get(produktuSpinner.getSelectedItemPosition()).getPrezioa() * Float.parseFloat(kantitatea.getText().toString())) + "");

            /** Kantitatea gakoa hustu**/
            kantitatea.setText("");
        }
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

    /**
     * Aurrekontua gordetzeko
     *
     * @param view
     */
    private void gorde(View view) {
        /** Alert-a sortu eta hasieratu **/
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
                                Toast.makeText(AurrekontuaSortu.this, "Ez dago daturik taulan. Datuak sartu behar dituzu gorde ahal izateko", Toast.LENGTH_LONG).show();
                                /** Datuak badaude **/
                            } else {
                                /** Sortzen du aurrekontuaren izena **/
                                aurrekontuIzena = "";
                                ida = 0;
                                for (int i = 0; i < aurrekontuak.size(); i++) {
                                    ida = aurrekontuak.get(i).getId();
                                }
                                aurrekontuIzena = "SM000" + ida;

                                Date data = new Date(2002, 11, 28);
                                /** Aurrekontu objetu bat sortzen du **/
                                Aurrekontua aurrekontua = new Aurrekontua(1, aurrekontuIzena, bezeroak.get(bezeroSpinner.getSelectedItemPosition()).getId(), bezeroak.get(bezeroSpinner.getSelectedItemPosition()).getIzenaAbizena(), "draft", Float.parseFloat(prezioaGuztira.getText().toString()), data);

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
                                        Menua.konexioa.insertAurrekontua(aurrekontua);
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
                                irtenAlertGabe();

                                Toast.makeText(AurrekontuaSortu.this, aurrekontuIzena + " aurrekontua ondo gorde da", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                })

                // Listener huts bat, Ez klikatzen bada ez da aplikazioa itxiko
                .setNegativeButton("EZ", null)
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
                .setPositiveButton("BAI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        if (getIntent().getBooleanExtra("EXIT", true)) {
                            /** Aurreko pantailara joaten da**/
                            Intent myIntent = new Intent(AurrekontuaSortu.this, AurrekontuaMenua.class);
                            myIntent.putExtra("produktuak", produktuak);
                            ActivityOptions options = ActivityOptions.makeCustomAnimation(getBaseContext(), R.anim.from_right, R.anim.from_right); // Animazioa definitzen
                            AurrekontuaSortu.this.startActivity(myIntent, options.toBundle());
                        }
                    }
                })

                // Listener huts bat, Ez klikatzen bada ez da aplikazioa itxiko
                .setNegativeButton("EZ", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    /**
     * Aurreko layout-era joateko alerta gabe
     */
    private void irtenAlertGabe() {
        Intent myIntent = new Intent(AurrekontuaSortu.this, AurrekontuaMenua.class);
        myIntent.putExtra("produktuak", produktuak);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(getBaseContext(), R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        AurrekontuaSortu.this.startActivity(myIntent, options.toBundle());
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