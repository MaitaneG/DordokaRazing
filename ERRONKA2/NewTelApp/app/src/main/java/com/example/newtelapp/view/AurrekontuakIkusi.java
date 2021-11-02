package com.example.newtelapp.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newtelapp.R;

public class AurrekontuakIkusi extends AppCompatActivity {
    /**
     *
     * Atributoak
     */
    private ImageButton irten;
    private ImageButton aldatu;
    private ImageButton borratu;

    /**
     *
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aurrekontuak_ikusi_layout);
        hasieratu();
    }

    private void hasieratu() {
        irten =findViewById(R.id.buttonIrtenAurrekontuaSortu);
        aldatu=findViewById(R.id.buttonAurrekontuaAldatu);
        borratu=findViewById(R.id.buttonAurrekontuaBorratu);

        irten.setOnClickListener(this::irten);
        aldatu.setOnClickListener(this::aldaturaJoan);
        borratu.setOnClickListener(this::borratu);
    }

    private void borratu(View view) {
        Toast toast1 = Toast.makeText(getApplicationContext(),"Borratu", Toast.LENGTH_LONG);
        toast1.show();
    }

    private void aldaturaJoan(View view) {
        Toast toast1 = Toast.makeText(getApplicationContext(),"Aldatu", Toast.LENGTH_LONG);
        toast1.show();
    }

    private void irten(View view) {
        Intent myIntent = new Intent(view.getContext(), AurrekontuaMenua.class);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right); // Animazioa definitzen
        this.startActivity(myIntent, options.toBundle());
    }
}
