package com.example.newtelapp;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.newtelapp.databinding.FragmentSecondBinding;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    //private SecondFragment sf;
    private Datuak datuak;
    private ArrayList<Produktua>produktuak;
    private TextView izena;
    private TextView kategoria;
    private TextView prezioa;
    private TextView kantitatea;
    private ImageButton botoiaAurrera;
    private ImageButton botoiaAtzera;
    private ImageButton botoiaIrten;

    private int index=0;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {


        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        datuak=new Datuak(view.getContext());
        produktuak=datuak.datuakItzuli();

        izena= (TextView) getView().findViewById(R.id.textViewIzenaInfo);
        kategoria=(TextView)getView().findViewById(R.id.textViewKategoriaInfo);
        prezioa=(TextView) getView().findViewById(R.id.textViewPrezioaInfo);
        kantitatea=(TextView)getView().findViewById(R.id.textViewKantitateaInfo);

        botoiaAurrera=view.findViewById(R.id.button_produktuak_aurrera);
        botoiaAtzera=view.findViewById(R.id.button_produktuak_atzera);
        botoiaIrten=view.findViewById(R.id.button_irten);

        botoiaAurrera.setOnClickListener(this::produktuakAurrera);
        botoiaAtzera.setOnClickListener(this::produktuakAtzera);
        botoiaIrten.setOnClickListener(this::irten);

        datuakAldatu();

        /**binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });**/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void datuakAldatu(){
        izena.setText(produktuak.get(index).getIzena());
        kategoria.setText(produktuak.get(index).getCategory());
        prezioa.setText(String.valueOf(produktuak.get(index).getPrezio())+" €");
        kantitatea.setText(Float.toString(produktuak.get(index).getKantitatea()));
    }

    public void animation(){
        Animation an = AnimationUtils.loadAnimation(getContext(),R.anim.to_right);
        izena.startAnimation(an);
        kategoria.startAnimation(an);
        prezioa.startAnimation(an);
        kantitatea.startAnimation(an);
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
        NavHostFragment.findNavController(SecondFragment.this)
                .navigate(R.id.action_SecondFragment_to_FirstFragment);
    }

}