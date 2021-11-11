package com.example.newtelapp.view;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.AuthenticationRequiredException;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newtelapp.R;
import com.example.newtelapp.model.Aurrekontua;
import com.example.newtelapp.model.AurrekontuaLerroa;
import com.example.newtelapp.model.Bezeroa;
import com.example.newtelapp.model.Produktua;

import java.util.ArrayList;

public class AurrekontuakIkusi extends AppCompatActivity {
    /**
     * Atributoak
     */
    // ImageButton
    private ImageButton irten;
    private ImageButton aldatu;
    private ImageButton borratu;
    // ArrayList-ak
    private ArrayList<Aurrekontua> aurrekontuak;
    private ArrayList<AurrekontuaLerroa> aurrekontuaLerroa;
    private ArrayList<Bezeroa> bezeroak;
    private ArrayList<Produktua> produktuak;

    // ListView
    private ListView aurrekontuaListView;
    // ArrayAdapter
    private ArrayAdapter<Aurrekontua> adapter = null;

    /**
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aurrekontuak_ikusi_layout);
        hasieratu(); // Konponenteak hasieratu
    }

    /**
     * Konponente guztiak hasieratzen dira
     */
    private void hasieratu() {
        /** Konponenteak hasieratu **/
        // Botoiak
        irten = findViewById(R.id.buttonIrtenAurrekontuaSortu);
        aldatu = findViewById(R.id.buttonAurrekontuaAldatu);
        borratu = findViewById(R.id.buttonAurrekontuaBorratu);
        // TextView
        aurrekontuaListView = findViewById(R.id.listView_aurrekontuak);
        /** Botoiei listerrenak jarri **/
        irten.setOnClickListener(this::irten);
        //aldatu.setOnClickListener(this::aldaturaJoan);
        //borratu.setOnClickListener(this::borratu);
        /** Aurrekontuen ArrayList-a betetzen da **/
        aurrekontuak = (ArrayList<Aurrekontua>) getIntent().getSerializableExtra("aurrekontuak");
        aurrekontuaLerroa = (ArrayList<AurrekontuaLerroa>) getIntent().getSerializableExtra("aurrekontuaLerroa");
        bezeroak = (ArrayList<Bezeroa>) getIntent().getSerializableExtra("bezeroak");
        produktuak = (ArrayList<Produktua>) getIntent().getSerializableExtra("produktuak");

        /** ListView-ko datuak kargatu **/
//        for(int i=0;i<aurrekontuaLerroa.size();i++){ //Movidas Maitane
//            for(int j=0;j<aurrekontuak.size();j++){
//                if(aurrekontuaLerroa.get(i).getIdAurrekontua()==aurrekontuak.get()){
//
//                }
//            }
//
//        }
//        arrayListPolita= new ArrayList<>();

        /** Adapterra sortu, datuak jarri eta listenerra izendatu **/
        adapter = new ArrayAdapter<>(AurrekontuakIkusi.this, android.R.layout.simple_list_item_1, aurrekontuak);
        aurrekontuaListView.setAdapter(adapter);
        aurrekontuaListView.setOnItemClickListener(this::aldatuBorratu);
    }

    /**
     * Aurrekontuak aldatzeko edo ezabatzeko
     *
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    private void aldatuBorratu(AdapterView<?> adapterView, View view, int i, long l) {
        new AlertDialog.Builder(this)

        .setTitle("Aurrekontuak Aldatu / Ezabatu")
        .setMessage("Aurrekontu hau ezabatu edo aldatu nahi duzu?")
        .setPositiveButton("Aldatu", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        })
        .setNegativeButton("Ezabatu", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Menua.konexioa.deleteAurrekontua(aurrekontuak.get((int) l));
                Toast.makeText(AurrekontuakIkusi.this, aurrekontuak.get((int) l).getIzena() + " aurrekontua behar bezala ezabatu da", Toast.LENGTH_SHORT).show();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Toast.makeText(AurrekontuakIkusi.this, "Sartu berriro pantaila honetara aldaketak ikusteko", Toast.LENGTH_SHORT).show();

            }
        })
        .setNeutralButton("Utzi", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        })
        .show();
    }

    /**
     * Aurreko pantailara doa
     *
     * @param view
     */
    private void irten(View view) {
        Intent myIntent = new Intent(view.getContext(), AurrekontuaMenua.class);
        // Aurrekontuen ArrayList-ak eramaten
        myIntent.putExtra("aurrekontuak", aurrekontuak);
        myIntent.putExtra("aurrekontuaLerroa", aurrekontuaLerroa);
        // Beeroen eta produktuen aurrekontuak eramaten
        myIntent.putExtra("bezeroak", bezeroak);
        myIntent.putExtra("produktuak", produktuak);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        this.startActivity(myIntent, options.toBundle());
    }
}
