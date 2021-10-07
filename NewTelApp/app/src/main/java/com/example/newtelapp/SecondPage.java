package com.example.newtelapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

/**
 *
 * Bigarren Layout-aren klasea
 */
public class SecondPage extends AppCompatActivity {

    /**
     *
     * Atributoak
     */
    private Datuak datuak;
    private ArrayList<Produktua>produktuak;
    private TextView izena;
    private TextView kategoria;
    private TextView prezioa;
    private TextView kantitatea;
    private ImageButton botoiaAurrera;
    private ImageButton botoiaAtzera;
    private ImageButton botoiaIrten;
    private ImageView irudia;

    private int index=0;
    public Integer[] nireIrudiak = {R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4};

    /**
     *
     * Layout-a sortzen denean
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        hasieratu();
    }

    /**
     *
     * Datuak jaso eta layout-eko objetu guztiak hasieratu
     */
    private void hasieratu() {
        /* Datuak hasieratu */
        datuak=new Datuak(this);
        produktuak=datuak.datuakItzuli();

        /* Botoiak aurkitzen eta aldagaietan gorde */
        izena=findViewById(R.id.textViewIzenaInfo);
        kategoria=findViewById(R.id.textViewKategoriaInfo);
        prezioa=findViewById(R.id.textViewPrezioaInfo);
        kantitatea=findViewById(R.id.textViewKantitateaInfo);
        irudia=findViewById(R.id.irudia);

        botoiaAurrera=findViewById(R.id.button_produktuak_aurrera);
        botoiaAtzera=findViewById(R.id.button_produktuak_atzera);
        botoiaIrten=findViewById(R.id.button_irten);

        /* Botoiei listenerra jarri */
        botoiaAurrera.setOnClickListener(this::produktuakAurrera);
        botoiaAtzera.setOnClickListener(this::produktuakAtzera);
        botoiaIrten.setOnClickListener(this::irten);

        datuakAldatu();
    }

    /**
     *
     * Aurreko edo hurrengo produktuen datuak jartzen ditu
     */
    public void datuakAldatu(){
        izena.setText(produktuak.get(index).getIzena());
        kategoria.setText(produktuak.get(index).getCategory());
        prezioa.setText(String.valueOf(produktuak.get(index).getPrezio())+" €");
        kantitatea.setText(Float.toString(produktuak.get(index).getKantitatea()));
        irudia.setImageResource(nireIrudiak[index]);
    }

    /**
     *
     * Testuari animazioak jartzen dio
     */
    public void animation(){
        Animation an = AnimationUtils.loadAnimation(this,R.anim.from_right);
        izena.startAnimation(an);
        kategoria.startAnimation(an);
        prezioa.startAnimation(an);
        kantitatea.startAnimation(an);
        irudia.startAnimation(an);
    }

    /**
     *
     * Index-a aldatzen du, datuak aldatu hurrengo produktuaren datuak bistaratzeko
     * @param view
     */
    public void produktuakAurrera( View view){
        animation();
        // Azken produktura heldu bada
        if(index==produktuak.size()-1){
            index=0;
        }else{
            index=index+1;
        }
        datuakAldatu();
    }

    /**
     *
     * Index-a aldatzen du, datuak aldatu aurreko produktuaren datuak bistaratzeko
     * @param view
     */
    public void produktuakAtzera(View view){
        animation();
        // Lehengo produktua bada
        if(index==0){
            index=produktuak.size()-1;
        }else{
            index=index-1;
        }
        datuakAldatu();
    }

    /**
     *
     * Aurreko layout-era joateko
     * @param view
     */
    public void irten(View view){
        Intent myIntent = new Intent(view.getContext(), FirstPage.class);
        // Animazioak definitu
        ActivityOptions options=ActivityOptions.makeCustomAnimation(this,R.anim.from_right, R.anim.from_right);

        // Activity hau itxi eta besteari abisatu
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myIntent.putExtra("EXIT", true);
        this.startActivity(myIntent, options.toBundle());
    }
}