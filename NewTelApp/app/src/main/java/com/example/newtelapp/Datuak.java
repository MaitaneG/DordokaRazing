package com.example.newtelapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

public class Datuak {
    private Context mContext;
    private ArrayList<String> datuak= new ArrayList<>();
    private ArrayList<Produktua> produktuak = new ArrayList<>();

    public Datuak(Context context){
        this.mContext = context;
        AssetManager am = mContext.getAssets();

        try {
            InputStream is = am.open("Produktuak.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            while((line = reader.readLine()) != null){
                if(Character.isDigit(line.charAt(0))){

                    line=line.substring(0, line.length()-1);
                    datuak.add(line);
                    String[] strings = line.split(";");
                    produktuak.add(new Produktua(Integer.parseInt(strings[0]),strings[1],strings[2], Float.parseFloat(strings[3])));
                    Log.d("linea",strings.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Produktua> datuakItzuli(){

        return produktuak;
    }

    public String datuakErakutsi(){

        return datuak.get(0);
    }


}
