package com.example.newtelapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.newtelapp.model.Produktua;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * Datuak klasea
 */
public class Datuak {
    /**
     *
     * Atributoak
     */
    private Context mContext;
    private ArrayList<String> datuak= new ArrayList<>();
    private ArrayList<Produktua> produktuak = new ArrayList<>();

    /**
     *  Datuak klasearen konstruktorea
     * @param context
     */
    public Datuak(Context context){
        this.mContext = context;
        AssetManager am = mContext.getAssets();

        try {
            /* Produktua fitxategia irakurtzen hasten da */
            InputStream is = am.open("Produktuak.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            /* Lerroz lerro irakurtzen du fitxategia */
            while((line = reader.readLine()) != null){
                if(Character.isDigit(line.charAt(0))){

                    line=line.substring(0, line.length()-1);
                    datuak.add(line);
                    String[] strings = line.split(";");
                    /* Produktuak sortu */
                    produktuak.add(new Produktua(Integer.parseInt(strings[0]),strings[1],strings[2], Float.parseFloat(strings[3]),Float.parseFloat(strings[4])));
                    Log.d("linea",strings.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return Produktuen ArrayList-a
     */
    public ArrayList<Produktua> datuakItzuli(){

        return produktuak;
    }

    /**
     *
     * Bakarrik probak egiteko
     *
     * @return lehengo produktuaren datuak String batean
     */
    public String datuakErakutsi(){

        return datuak.get(0);
    }


}
