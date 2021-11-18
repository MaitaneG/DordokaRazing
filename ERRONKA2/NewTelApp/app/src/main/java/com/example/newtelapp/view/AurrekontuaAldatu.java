package com.example.newtelapp.view;

import static com.example.newtelapp.view.Menua.konexioa;

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
import com.example.newtelapp.hariak.Konexioa;
import com.example.newtelapp.model.Aurrekontua;
import com.example.newtelapp.model.AurrekontuaLerroa;
import com.example.newtelapp.model.Produktua;

import java.util.ArrayList;

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
    private ArrayList<AurrekontuaLerroa> insertEgitekoAurrekontuLerroa;
    // Objektu bat
    private Aurrekontua aurrekontua;
    // TableLayout
    private TableLayout taula;


    // TableRow bakoitzeko izena
    private String produktuIzena = "";
    // TableRow bakoitzeko kantitatea
    private float produktuKantitatea = (float) 0.1;
    // TableRow bakoitzeko prezioa
    private float produktuPrezioa = (float) 0.1;

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
        irten = findViewById(R.id.buttonIrtenAurrekontuaAldatu);
        gorde = findViewById(R.id.buttonGordeAurrekontuaAldatu);
        produktuaGehitu = findViewById(R.id.buttonProduktuaGehituAurrekontuaAldatu);
        // TextView
        textViewBezeroaAldatu = findViewById(R.id.textViewBezeroaAldatu);
        prezioaGuztira = findViewById(R.id.textViewPrezioaGuztiraInformazioaAurrekontuaAldatu);
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
        insertEgitekoAurrekontuLerroa = new ArrayList<>();

        textViewBezeroaAldatu.setText(aurrekontua.getBezeroaIzena());

        /**Spinnerak kargatu**/
        spinnerraKargatu();
        /** Taula sortu eta hasieratu **//** Taula sortu **/
        taula = findViewById(R.id.taulaAurrekontuaAldatu);
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
        for (int i = 0; i < aurrekontuaLerroa.size(); i++) {
            int x = i;
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
            column2.setTextColor(R.color.black);
            column2.setWidth(px23);
            // Hirugarren zutabea
            TextView column3 = new TextView(this);
            column3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            column3.setTextColor(R.color.black);
            column3.setWidth(px23);
            // Botoia
            ImageButton button = new ImageButton(this);
            button.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            button.setBackgroundResource(R.drawable.borratu_botoia_txikia);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(AurrekontuaAldatu.this).setTitle("Produktuak ezabatzen")// Dialog-ari titulua jarri
                            .setMessage("Ziur zaude produktu hau ezabatu nahi duzula?") // Dialog-aren mezua jarri

                            // Baiezko aukera klikatzen bada, aplikazioa itxiko da
                            .setPositiveButton("BAI", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    AurrekontuaLerroa ak = aurrekontuaLerroa.get(x);
                                    konexioa.deleteAurrekontuaLerroa(ak);
                                    String totalBerria= konexioa.selectTotalBerria(aurrekontua)+"";
                                    prezioaGuztira.setText(totalBerria);
                                    konexioa.updateAurrekontua(aurrekontua, Float.parseFloat(totalBerria));
                                    taula.removeViewAt(1);
                                }

                            }).setNegativeButton("EZ", null)
                            .show();

                }
            });


            /** Zutabeak betzen du **/
            column1.setText(aurrekontuaLerroa.get(i).getIzenaProduktua());
            column2.setText((int) aurrekontuaLerroa.get(i).getKantitatea() + "");
            column3.setText(aurrekontuaLerroa.get(i).getPrezioaProduktua() + "");

            /** Zutabeak ilaran sartu **/
            tableRow.addView(column1);
            tableRow.addView(column2);
            tableRow.addView(column3);
            tableRow.addView(button);

            /** Ilara taulan sartzen du **/
            taula.addView(tableRow);

            prezioaGuztira.setText(Float.parseFloat(prezioaGuztira.getText().toString()) + (aurrekontuaLerroa.get(i).getPrezioaProduktua() * aurrekontuaLerroa.get(i).getKantitatea()) + "");
        }
    }

    private void borratu(View view) {
        new AlertDialog.Builder(this).setTitle("Produktuak ezabatzen")// Dialog-ari titulua jarri
                .setMessage("Ziur zaude produktu hau ezabatu nahi duzula?") // Dialog-aren mezua jarri

                // Baiezko aukera klikatzen bada, aplikazioa itxiko da
                .setPositiveButton("BAI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        }

                }).setNegativeButton("EZ", null)
                .show();
        ;
    }

    /**
     * Produktu bat gehitzeko taulara
     *
     * @param view
     */
    @SuppressLint("ResourceAsColor")
    private void produktuaGehitu(View view) {
        new AlertDialog.Builder(this).setTitle("Produktuak gehitzen")// Dialog-ari titulua jarri
                .setMessage("Ziur zaude produktu hau gehitu nahi duzula?") // Dialog-aren mezua jarri

                // Baiezko aukera klikatzen bada, aplikazioa itxiko da
                .setPositiveButton("BAI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        if (getIntent().getBooleanExtra("EXIT", true)) {
                            // Kantitatea hutsik badago
                            if (kantitatea.getText().toString().equals("")) {
                                Toast.makeText(AurrekontuaAldatu.this, "Produktuen kantitatea sartu behar duzu", Toast.LENGTH_SHORT).show();
                                // Kantitatea ez badago hutsik
                            } else {
                                /** Ilara bat sortzen du **/
                                TableRow tableRow = new TableRow(AurrekontuaAldatu.this);

                                /** Hiru zutabe sortzen du **/
                                // Zutabeen zabalera definitzeko (dp-tik pixeletara pasatu)
                                DisplayMetrics displayMetrics = AurrekontuaAldatu.this.getResources().getDisplayMetrics();
                                int px1 = Math.round(115 * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
                                int px23 = Math.round(70 * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));

                                // Lehenengo zutabea
                                TextView column1 = new TextView(AurrekontuaAldatu.this);
                                column1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                column1.setTextColor(R.color.black);
                                column1.setWidth(px1);
                                // Bigarren zutabea
                                TextView column2 = new TextView(AurrekontuaAldatu.this);
                                column2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                column1.setTextColor(R.color.black);
                                column2.setWidth(px23);
                                // Hirugarren zutabea
                                TextView column3 = new TextView(AurrekontuaAldatu.this);
                                column3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                column1.setTextColor(R.color.black);
                                column3.setWidth(px23);
                                // Botoia
                                ImageButton button = new ImageButton(AurrekontuaAldatu.this);
                                button.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                                button.setBackgroundResource(R.drawable.borratu_botoia_txikia);
                                button.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        new AlertDialog.Builder(AurrekontuaAldatu.this).setTitle("Produktuak ezabatzen")// Dialog-ari titulua jarri
                                                .setMessage("Ziur zaude produktu hau ezabatu nahi duzula?") // Dialog-aren mezua jarri

                                                // Baiezko aukera klikatzen bada, aplikazioa itxiko da
                                                .setPositiveButton("BAI", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
//                                                        AurrekontuaLerroa ak = aurrekontuaLerroa.get(x);
//                                                        Menua.konexioa.deleteAurrekontuaLerroa(ak);
                                                    }

                                                }).setNegativeButton("EZ", null)
                                                .show();

                                    }
                                });

                                /** Zutabeak betzen du **/
                                column1.setText(produktuak.get(spinnerProduktuAldatu.getSelectedItemPosition()).getIzena());
                                column2.setText(kantitatea.getText().toString());
                                column3.setText(produktuak.get(spinnerProduktuAldatu.getSelectedItemPosition()).getPrezioa() + "");

                                /** Zutabeak ilaran sartu **/
                                tableRow.addView(column1);
                                tableRow.addView(column2);
                                tableRow.addView(column3);
                                tableRow.addView(button);

                                /** Ilara taulan sartzen du **/
                                taula.addView(tableRow);

                                prezioaGuztira.setText(Float.parseFloat(prezioaGuztira.getText().toString()) + (produktuak.get(spinnerProduktuAldatu.getSelectedItemPosition()).getPrezioa() * Float.parseFloat(kantitatea.getText().toString())) + "");

                                /** Datuen lehengo ilara hartzen du **/
                                View child = taula.getChildAt(1);

                                /** Hutsik badago **/
                                if (child == null) {
                                    Toast.makeText(AurrekontuaAldatu.this, "Ez dago daturik taulan. Datuak sartu behar dituzu gorde ahal izateko", Toast.LENGTH_LONG).show();
                                    /** Datuak badaude **/
                                } else {

                                    ida = aurrekontua.getId();

                                    /** AurrekontuLerroa gehitzeko haria **/
                                    Thread insertAurrekontuaLerroa = new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            AurrekontuaLerroa aurrekontuaLerroa = new AurrekontuaLerroa(1, ida, produktuak.get(spinnerProduktuAldatu.getSelectedItemPosition()).getId(), produktuak.get(spinnerProduktuAldatu.getSelectedItemPosition()).getIzena(), produktuak.get(spinnerProduktuAldatu.getSelectedItemPosition()).getPrezioa(), Float.parseFloat(kantitatea.getText().toString()), (produktuak.get(spinnerProduktuAldatu.getSelectedItemPosition()).getPrezioa() * Float.parseFloat(kantitatea.getText().toString())));

                                            konexioa.insertAurrekontuaLerroa(aurrekontuaLerroa);
                                            konexioa.updateAurrekontua(aurrekontua, Float.parseFloat(prezioaGuztira.getText().toString()));
                                            /** Kantitatea gakoa hustu**/
                                            kantitatea.setText("");
                                        }
                                    });
                                    insertAurrekontuaLerroa.start();
                                }
                            }
                        }
                    }
                }).setNegativeButton("EZ", null)
                .show();
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
                            irtenAlertGabe();
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
                        Intent myIntent = new Intent(AurrekontuaAldatu.this, AurrekontuaMenua.class);
                        myIntent.putExtra("produktuak", produktuak);
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
     * Aurreko pantailara joaten da alerta atera gabe
     */
    private void irtenAlertGabe() {
        Intent myIntent = new Intent(AurrekontuaAldatu.this, AurrekontuaMenua.class);
        myIntent.putExtra("produktuak", produktuak);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(getBaseContext(), R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        AurrekontuaAldatu.this.startActivity(myIntent, options.toBundle());
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
