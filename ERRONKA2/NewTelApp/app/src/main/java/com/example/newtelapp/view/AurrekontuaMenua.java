package com.example.newtelapp.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newtelapp.R;
import com.example.newtelapp.model.Aurrekontua;
import com.example.newtelapp.model.AurrekontuaLerroa;
import com.example.newtelapp.model.Bezeroa;
import com.example.newtelapp.model.Produktua;

import java.util.ArrayList;

/**
 * AurrekontuaMenua-ren Layout-aren klasea
 */
public class AurrekontuaMenua extends AppCompatActivity {

    /**
     * Atributoak
     */
    // ImageButton
    private ImageButton aurrekontuaSortu;
    private ImageButton aurrrekontuakIkusi;
    private ImageButton irten;
    // ArrayList-a
    private ArrayList<Bezeroa> bezeroak;
    private ArrayList<Aurrekontua> aurrekontuak;
    private ArrayList<AurrekontuaLerroa> aurrekontuaLerroa;
    private ArrayList<Produktua> produktuak;

    /**
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aurrekontu_menu_layout);
        hasieratu();
    }

    /**
     * Konponente guztiak hasieratzen dira
     */
    private void hasieratu() {
        /** Botoiak hasieratu **/
        aurrekontuaSortu = findViewById(R.id.buttonAurrekontuaSortu);
        aurrrekontuakIkusi = findViewById(R.id.buttonAurrekontuakIkusi);
        irten = findViewById(R.id.buttonIrtenMenuaAurrekontuMenua);

        /** Botoiei listerrenak jarri **/
        aurrekontuaSortu.setOnClickListener(this::aurrekontuaSorturaJoan);
        aurrrekontuakIkusi.setOnClickListener(this::aurrekontuakIkusiraJoan);
        irten.setOnClickListener(this::irten);

        /** ArrayList-ak informazioz bete **/
        bezeroak = Menua.konexioa.selectBezeroak();
        aurrekontuak = Menua.konexioa.selectAurrekontuak();
        aurrekontuaLerroa = Menua.konexioa.selectAurrekontuaLerroa();
        produktuak = (ArrayList<Produktua>) getIntent().getSerializableExtra("produktuak");
    }

    /**
     * AurrekontuakIkusi activity-ra doa
     *
     * @param view
     */
    private void aurrekontuakIkusiraJoan(View view) {
        Intent myIntent = new Intent(this, AurrekontuakIkusi.class);

        // Aurrekontuen ArrayList-ak eramaten
        myIntent.putExtra("aurrekontuak", aurrekontuak);
        myIntent.putExtra("aurrekontuaLerroa", aurrekontuaLerroa);
        // Beeroen eta produktuen aurrekontuak eramaten
        myIntent.putExtra("bezeroak", bezeroak);
        myIntent.putExtra("produktuak", produktuak);

        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        this.startActivity(myIntent, options.toBundle());
    }

    /**
     * AurrekontuaSortu activity-ra doa
     *
     * @param view
     */
    private void aurrekontuaSorturaJoan(View view) {
        Intent myIntent = new Intent(this, AurrekontuaSortu.class);

        // Bezeroen eta produktuen ArrayList-ak eramaten du
        myIntent.putExtra("bezeroak", bezeroak);
        myIntent.putExtra("produktuak", produktuak);
        myIntent.putExtra("aurrekontuak", aurrekontuak);

        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        this.startActivity(myIntent, options.toBundle());
    }

    /**
     * Aurreko pantailara doa
     */
    private void irten() {
        Intent myIntent = new Intent(AurrekontuaMenua.this, Menua.class);
        // Animazioak definitu
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right);

        // Activity hau itxi eta besteari abisatu
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myIntent.putExtra("EXIT", true);
        this.startActivity(myIntent, options.toBundle());
    }

    /**
     * Aurreko pantailara doa
     *
     * @param view
     */
    private void irten(View view) {
        irten();
    }

    /**
     * Atzera joateko botoia klikatzean
     */
    @Override
    public void onBackPressed() {
        irten();
    }
}
