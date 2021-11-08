package com.example.newtelapp.view;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
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
    private ArrayList<Object>arrayListPolita;
    //private ArrayList<Bezeroa> bezeroak;
    //private ArrayList<Produktua> produktuak;

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
        borratu.setOnClickListener(this::borratu);
        /** Aurrekontuen ArrayList-a betetzen da **/
        aurrekontuak = (ArrayList<Aurrekontua>) getIntent().getSerializableExtra("aurrekontuak");
        aurrekontuaLerroa = (ArrayList<AurrekontuaLerroa>) getIntent().getSerializableExtra("aurrekontuaLerroa");
        //bezeroak = (ArrayList<Bezeroa>) getIntent().getSerializableExtra("bezeroak");
        //produktuak = (ArrayList<Produktua>) getIntent().getSerializableExtra("produktuak");

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

        /** Adapterra sortu eta adatuak jarri **/
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, aurrekontuak);
        aurrekontuaListView.setAdapter(adapter);
    }

    /**
     * Aurrekontu bat borratzeko
     *
     * @param view
     */
    private void borratu(View view) {
        /** Alert-a sortu eta hasieratu **/
        new AlertDialog.Builder(this)
                .setTitle("Aurrekontu bat ezabatzen")// Dialog-ari titulua jarri
                .setMessage("Ziur zaude aurrekontua ezabatu nahi duzula?") // Dialog-aren mezua jarri

                // Baiezko aukera klikatzen bada, aplikazioa itxiko da
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        if (getIntent().getBooleanExtra("EXIT", true)) {
                            Aurrekontua borratzekoAurrekontua = (Aurrekontua) aurrekontuaListView.getSelectedItem();

                            //Menua.konexioa.deleteAurrekontua(borratzekoAurrekontua);

                            Toast.makeText(AurrekontuakIkusi.this, "Aurrekontua behar bezala borratu da", Toast.LENGTH_SHORT).show();
                        }
                    }
                })

                // Listener huts bat, Ez klikatzen bada ez da aplikazioa itxiko
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    /**
     * Aurrekontu bat aldatzeko pantailara doa
     *
     * @param view
     */
//    private void aldaturaJoan(View view) {
//        Intent myIntent = new Intent(view.getContext(), AurrekontuaSortu.class);
//            myIntent.putExtra("aurrekontuak",aurrekontuak);
//            myIntent.putExtra("produktuak",produktuak);
//            myIntent.putExtra("bezeroak",bezeroak);
//            // Tambien tiene que mandarle productos y clientes para que no de error
//        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
//        this.startActivity(myIntent, options.toBundle());
//
//        Toast.makeText(getApplicationContext(), "Beste pantila batera joaten", Toast.LENGTH_LONG).show();
//    }

    /**
     * Aurreko pantailara doa
     *
     * @param view
     */
    private void irten(View view) {
        Intent myIntent = new Intent(view.getContext(), AurrekontuaMenua.class);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        this.startActivity(myIntent, options.toBundle());
    }
}
