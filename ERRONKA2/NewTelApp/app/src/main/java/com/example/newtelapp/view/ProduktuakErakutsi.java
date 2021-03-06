package com.example.newtelapp.view;

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


import com.example.newtelapp.R;
import com.example.newtelapp.model.Produktua;

import java.util.ArrayList;

/**
 * Bigarren Layout-aren klasea
 */
public class ProduktuakErakutsi extends AppCompatActivity implements SearchView.OnQueryTextListener {

    /**
     *
     * Atributoak
     */
    /**
     * ArrayList-ak
     **/
    private ArrayList<Produktua> produktuak;
    private ArrayList<Produktua> produktuakBilatu;
    /**
     * TextView-ak
     **/
    private TextView izena;
    private TextView kategoria;
    private TextView prezioa;
    private TextView kantitatea;
    /**
     * ImageButton-ak
     **/
    private ImageButton botoiaAurrera;
    private ImageButton botoiaAtzera;
    private ImageButton botoiaIrten;
    /**
     * ImageView-a
     **/
    private ImageView irudia;
    /**
     * SearchView-a
     **/
    private SearchView bilatzailea;
    /**
     * ListView-a
     **/
    private ListView lista;
    /**
     * ArrayAdapter-a
     **/
    private ArrayAdapter<Produktua> adapter = null;
    /**
     * Argazkien gauzak
     **/
    private int index = 0;
    public Integer[] nireIrudiak = {R.drawable.i2, R.drawable.i3, R.drawable.i4, R.drawable.i5, R.drawable.i6, R.drawable.i7};

    /**
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produktuak_layout);
        hasieratu();
    }

    /**
     * Datuak jaso eta layout-eko objetu guztiak hasieratu
     */
    private void hasieratu() {
        /** Datuak hasieratu **/
        produktuak = (ArrayList<Produktua>) getIntent().getSerializableExtra("produktuak");
        produktuakBilatu = new ArrayList<>();
        produktuakBilatu.addAll(produktuak);

        /** Konponenteak aurkitu eta aldagaietan gorde **/
        // TextView
        izena = findViewById(R.id.textViewIzenaInfo);
        kategoria = findViewById(R.id.textViewKategoriaInfo);
        prezioa = findViewById(R.id.textViewPrezioaInfo);
        kantitatea = findViewById(R.id.textViewKantitateaInfo);
        // ImageView
        irudia = findViewById(R.id.ImageView_irudia);
        // ListView
        lista = findViewById(R.id.ListViewProduktuLista);
        // SearchView
        bilatzailea = findViewById(R.id.SearchViewBilatzailea);
        // Button
        botoiaAurrera = findViewById(R.id.button_produktuak_aurrera);
        botoiaAtzera = findViewById(R.id.buttonProduktuakAtzera);
        botoiaIrten = findViewById(R.id.buttonIrtenMenua);

        /** Botoiei listenerra jarri **/
        botoiaAurrera.setOnClickListener(this::produktuakAurrera);
        botoiaAtzera.setOnClickListener(this::produktuakAtzera);
        botoiaIrten.setOnClickListener(this::irten);
        bilatzailea.setOnQueryTextListener(this);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int id = produktuakBilatu.get(i).getId();
                datuakAldatuBilatzaile(id - 1);
            }
        });

        /** Zabalgarria ezkutatzen du **/
        lista.setVisibility(View.INVISIBLE);

        /** Datuak kargatu **/
        datuakAldatu();
    }

    /**
     * Bilatzailea erabili nahi izanez gero erabiliko dugun metodoa da.
     * Bilatzailean idatzita dugun hitza konprobatzen joango da gure produktu guztien listan eta,
     * produkturen batek bere izenean bilatzen ari garen testua baldin badu Listan agertuko da.
     * Listako produkturen bat klikatu ezkero zuzenean produktu horretara joango da.
     *
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
            // Produktu bakoitzaren izenean begiratuko dugu.
            for (Produktua p : produktuak) {
                // Bilatzaileko testuak izenarekin koiziditzen badu erakutsiko den listara gehituko da.
                if (p.getIzena().toLowerCase().contains(testua.toLowerCase())) {

                    produktuakBilatu.add(p);
                }
            }
            adapter = new ArrayAdapter<Produktua>(this, android.R.layout.simple_list_item_1, produktuakBilatu);
            lista.setAdapter(adapter);
        }
    }

    /**
     * Aurreko edo hurrengo produktuen datuak jartzen ditu
     */
    public void datuakAldatu() {
        // Produktuen ArrayList-a hutsik badago
        if (produktuak.size() != 0) {
            izena.setText(produktuak.get(index).getIzena());
            kategoria.setText(produktuak.get(index).getKategoria());
            prezioa.setText(produktuak.get(index).getPrezioa() + " ???");
            kantitatea.setText(Float.toString(produktuak.get(index).getKantitatea()));
            irudia.setImageResource(nireIrudiak[index]);
        }
    }

    /**
     * Bilatzailean aukerattuatakoa agertuko da
     *
     * @param indexa
     */
    public void datuakAldatuBilatzaile(int indexa) {
        lista.setVisibility(View.INVISIBLE);
        bilatzailea.setQuery("", false);
        bilatzailea.clearFocus();
        izena.setText(produktuak.get(indexa - 1).getIzena());
        kategoria.setText(produktuak.get(indexa - 1).getKategoria());
        prezioa.setText(produktuak.get(indexa - 1).getPrezioa() + " ???");
        kantitatea.setText(Float.toString(produktuak.get(indexa - 1).getKantitatea()));
        irudia.setImageResource(nireIrudiak[indexa - 1]);
        index = produktuak.get(indexa - 1).getId() - 2;
    }

    /**
     * Testuari animazioak jartzen dio
     */
    public void animation() {
        Animation an = AnimationUtils.loadAnimation(this, R.anim.from_right);
        izena.startAnimation(an);
        kategoria.startAnimation(an);
        prezioa.startAnimation(an);
        kantitatea.startAnimation(an);
        irudia.startAnimation(an);
    }

    /**
     * Index-a aldatzen du, datuak aldatu hurrengo produktuaren datuak bistaratzeko
     *
     * @param view
     */
    public void produktuakAurrera(View view) {
        animation();
        // Azken produktura heldu bada
        if (index == produktuak.size() - 1) {
            index = 0;
        } else {
            index = index + 1;
        }
        datuakAldatu();
    }

    /**
     * Index-a aldatzen du, datuak aldatu aurreko produktuaren datuak bistaratzeko
     *
     * @param view
     */
    public void produktuakAtzera(View view) {
        animation();
        // Lehengo produktua bada
        if (index == 0) {
            index = produktuak.size() - 1;
        } else {
            index = index - 1;
        }
        datuakAldatu();
    }

    /**
     * Aurreko layout-era joateko
     *
     * @param view
     */
    public void irten(View view) {
        Intent myIntent = new Intent(view.getContext(), Menua.class);
        // Animazioak definitu
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this, R.anim.from_right, R.anim.from_right);

        // Activity hau itxi eta besteari abisatu
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myIntent.putExtra("EXIT", true);
        this.startActivity(myIntent, options.toBundle());
    }

    /**
     * Buskadorean submit egiterakoan
     *
     * @param s
     * @return
     */
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    /**
     * Buskadorean zerbait aldatzerakoan
     *
     * @param s
     * @return
     */
    @Override
    public boolean onQueryTextChange(String s) {
        filtratu(s);
        return false;
    }
}