package com.example.newtelapp.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newtelapp.R;

public class AurrekontuaMenua extends AppCompatActivity {

    /**
     *
     * Atributoak
     */
    private ImageButton aurrekontuaSortu;
    private ImageButton aurrrekontuakIkusi;
    private ImageButton irten;

    /**
     *
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aurrekontu_menu_layout);
        hasieratu();
    }

    private void hasieratu() {
        aurrekontuaSortu=findViewById(R.id.buttonAurrekontuaSortu);
        aurrrekontuakIkusi=findViewById(R.id.buttonErakutsiProduktuak);
        irten=findViewById(R.id.buttonIrten);

        aurrekontuaSortu.setOnClickListener(this::aurrekontuaSorturaJoan);
        aurrrekontuakIkusi.setOnClickListener(this::aurrekontuakIkusiraJoan);
        irten.setOnClickListener(this::irten);
    }

    private void irten(View view) {
        Intent myIntent = new Intent(view.getContext(), Menua.class);
        // Animazioak definitu
        ActivityOptions options=ActivityOptions.makeCustomAnimation(this,R.anim.from_right, R.anim.from_right);

        // Activity hau itxi eta besteari abisatu
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myIntent.putExtra("EXIT", true);
        this.startActivity(myIntent, options.toBundle());
    }

    private void aurrekontuakIkusiraJoan(View view) {
        Intent myIntent = new Intent(view.getContext(), AurrekontuakIkusi.class);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        this.startActivity(myIntent, options.toBundle());
    }

    private void aurrekontuaSorturaJoan(View view) {
        Intent myIntent = new Intent(view.getContext(), AurrekontuaSortu.class);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        this.startActivity(myIntent, options.toBundle());
    }
}
