package com.example.newtelapp;

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

public class SecondPage extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        hasieratu();
    }

    private void hasieratu() {
        datuak=new Datuak(this);
        produktuak=datuak.datuakItzuli();

        izena=findViewById(R.id.textViewIzenaInfo);
        kategoria=findViewById(R.id.textViewKategoriaInfo);
        prezioa=findViewById(R.id.textViewPrezioaInfo);
        kantitatea=findViewById(R.id.textViewKantitateaInfo);
        irudia=findViewById(R.id.irudia);

        botoiaAurrera=findViewById(R.id.button_produktuak_aurrera);
        botoiaAtzera=findViewById(R.id.button_produktuak_atzera);
        botoiaIrten=findViewById(R.id.button_irten);

        botoiaAurrera.setOnClickListener(this::produktuakAurrera);
        botoiaAtzera.setOnClickListener(this::produktuakAtzera);
        botoiaIrten.setOnClickListener(this::irten);

        datuakAldatu();
    }

    public void datuakAldatu(){
        izena.setText(produktuak.get(index).getIzena());
        kategoria.setText(produktuak.get(index).getCategory());
        prezioa.setText(String.valueOf(produktuak.get(index).getPrezio())+" €");
        kantitatea.setText(Float.toString(produktuak.get(index).getKantitatea()));
        irudia.setImageResource(nireIrudiak[index]);
    }

    public void animation(){
        Animation an = AnimationUtils.loadAnimation(this,R.anim.to_right);
        izena.startAnimation(an);
        kategoria.startAnimation(an);
        prezioa.startAnimation(an);
        kantitatea.startAnimation(an);
        irudia.startAnimation(an);
    }

    public void produktuakAurrera( View view){
        animation();
        if(index==produktuak.size()-1){
            index=0;
        }else{
            index=index+1;
        }
        datuakAldatu();
    }

    public void produktuakAtzera(View view){
        animation();
        if(index==0){
            index=produktuak.size()-1;
        }else{
            index=index-1;
        }
        datuakAldatu();
    }

    public void irten(View view){
        Intent myIntent = new Intent(view.getContext(), FirstPage.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myIntent.putExtra("EXIT", true);
        startActivity(myIntent);
    }

}