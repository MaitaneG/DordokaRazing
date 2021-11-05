package com.example.newtelapp.view;

import android.app.ActivityOptions;
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
import com.example.newtelapp.model.Produktua;

import java.util.ArrayList;

public class AurrekontuakIkusi extends AppCompatActivity {
    /**
     * Atributoak
     */
    private ImageButton irten;
    private ImageButton aldatu;
    private ImageButton borratu;

    private ArrayList<Aurrekontua> aurrekontuak;

    private ListView aurrekontuaListView;

    private ArrayAdapter<Aurrekontua> adapter = null;

    /**
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aurrekontuak_ikusi_layout);
        hasieratu();
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
        aldatu.setOnClickListener(this::aldaturaJoan);
        borratu.setOnClickListener(this::borratu);
        /** Aurrekontuen ArrayList-a betetzen da **/
        aurrekontuak = (ArrayList<Aurrekontua>) getIntent().getSerializableExtra("aurrekontu");

        datuakErakutsi();
    }

    /**
     * ListView-ko datuak kargatu
     */
    private void datuakErakutsi() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, aurrekontuak);
        aurrekontuaListView.setAdapter(adapter);

    }

    /**
     * Aurrekontu bat borratzeko
     *
     * @param view
     */
    private void borratu(View view) {
        Aurrekontua borratzekoAurrekontua = (Aurrekontua) aurrekontuaListView.getSelectedItem();

        aurrekontuak.remove(borratzekoAurrekontua); // Falta borrarlo de la base de datos

        Toast toast1 = Toast.makeText(getApplicationContext(), "Borratu", Toast.LENGTH_LONG);
        toast1.show();
    }

    /**
     * Aurrekontu bat aldatzeko pantailara doa
     *
     * @param view
     */
    private void aldaturaJoan(View view) {
        Toast toast1 = Toast.makeText(getApplicationContext(), "Aldatu", Toast.LENGTH_LONG);
        toast1.show();
    }

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
