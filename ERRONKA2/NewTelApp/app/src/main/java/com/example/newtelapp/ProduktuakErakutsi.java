package com.example.newtelapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

/**
 *
 * Bigarren Layout-aren klasea
 */
public class ProduktuakErakutsi extends AppCompatActivity implements SearchView.OnQueryTextListener {

    /**
     *
     * Atributoak
     */
    private Datuak datuak;

    private ArrayList<Produktua>produktuak;
    private ArrayList<Produktua>produktuakBilatu;

    private TextView izena;
    private TextView kategoria;
    private TextView prezioa;
    private TextView kantitatea;
    private ImageButton botoiaAurrera;
    private ImageButton botoiaAtzera;
    private ImageButton botoiaIrten;
    private ImageView irudia;
    private SearchView bilatzailea;
    private ListView lista;
    private ArrayAdapter<Produktua> adapter = null;

    private int index=0;
    public Integer[] nireIrudiak = {R.drawable.i2, R.drawable.i3, R.drawable.i4, R.drawable.i5, R.drawable.i6, R.drawable.i7};

    /**
     *
     * Layout-a sortzen denean
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produktuak_layout);
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
        produktuakBilatu=new ArrayList<>();
        produktuakBilatu.addAll(produktuak);

        /* Botoiak aurkitzen eta aldagaietan gorde */
        izena=findViewById(R.id.textViewIzenaInfo);
        kategoria=findViewById(R.id.textViewKategoriaInfo);
        prezioa=findViewById(R.id.textViewPrezioaInfo);
        kantitatea=findViewById(R.id.textViewKantitateaInfo);
        irudia=findViewById(R.id.irudia);
        lista= findViewById(R.id.ListViewProduktuLista);
        bilatzailea=findViewById(R.id.SearchViewBilatzailea);

        botoiaAurrera=findViewById(R.id.button_produktuak_aurrera);
        botoiaAtzera=findViewById(R.id.buttonProduktuakAtzera);
        botoiaIrten=findViewById(R.id.buttonIrten);

        /* Botoiei listenerra jarri */
        botoiaAurrera.setOnClickListener(this::produktuakAurrera);
        botoiaAtzera.setOnClickListener(this::produktuakAtzera);
        botoiaIrten.setOnClickListener(this::irten);
        bilatzailea.setOnQueryTextListener(this);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int ida =   produktuakBilatu.get(i).getId();
                datuakAldatuBilatzaile(ida-1);
            }
        });

        /* Zabalgarria ezkutatzen du */
        lista.setVisibility(View.INVISIBLE);

        datuakAldatu();
    }

    /**
     *
     * Bilatzailea erabili nahi izanez gero erabiliko dugun metodoa da.
     * Bilatzailean idatzita dugun hitza konprobatzen joango da gure produktu guztien listan eta,
     * produkturen batek bere izenean bilatzen ari garen testua baldin badu Listan agertuko da.
     * Listako produkturen bat klikatu ezkero zuzenean produktu horretara joango da.
     * @param testua
     */
    public void filtratu(String testua) {
        int luzera = testua.length();
        produktuakBilatu.clear();
        if (luzera == 0) {
            produktuakBilatu.addAll(produktuak);
            lista.setVisibility(View.INVISIBLE);

            //Bilatzailean zerbait idatzita baldin badago hitz hori konprobatuko da.
        } else {
            lista.setVisibility(View.VISIBLE);
            //produktu bakoitzaren izenean begiratuko dugu.
            for (Produktua p : produktuak) {
                //bilatzaileko testuak izenarekin koiziditzen badu erakutsiko den listara gehituko da.
                if (p.getIzena().toLowerCase().contains(testua.toLowerCase())) {

                    produktuakBilatu.add(p);
                }
            }
            adapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, produktuakBilatu);
            lista.setAdapter(adapter);
        }
    }

    /**
     *
     * Bilatzailean aukerattuatakoa agertuko da
     * @param indexa
     */
    public void datuakAldatuBilatzaile(int indexa){
        lista.setVisibility(View.INVISIBLE);
        bilatzailea.setQuery("", false);
        bilatzailea .clearFocus();
        izena.setText(produktuak.get(indexa-1).getIzena());
        kategoria.setText(produktuak.get(indexa-1).getCategory());
        prezioa.setText(produktuak.get(indexa-1).getPrezio()+" €");
        kantitatea.setText(Float.toString(produktuak.get(indexa-1).getKantitatea()));
        irudia.setImageResource(nireIrudiak[indexa-1]);
        index= produktuak.get(indexa-1).getId()-2;
    }

    /**
     *
     * Aurreko edo hurrengo produktuen datuak jartzen ditu
     */
    public void datuakAldatu(){
        izena.setText(produktuak.get(index).getIzena());
        kategoria.setText(produktuak.get(index).getCategory());
        prezioa.setText(produktuak.get(index).getPrezio()+" €");
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
        Intent myIntent = new Intent(view.getContext(), Menua.class);
        // Animazioak definitu
        ActivityOptions options=ActivityOptions.makeCustomAnimation(this,R.anim.from_right, R.anim.from_right);

        // Activity hau itxi eta besteari abisatu
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myIntent.putExtra("EXIT", true);
        this.startActivity(myIntent, options.toBundle());
    }

    /**
     *
     * Buskadorean submit egiterakoan
     * @param s
     * @return
     */
    @Override
    public boolean onQueryTextSubmit(String s) {

        return false;
    }

    /**
     *
     * Buskadorean zerbait aldatzerakoan
     * @param s
     * @return
     */
    @Override
    public boolean onQueryTextChange(String s) {
        filtratu(s);
        return false;
    }
}