package com.example.newtelapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        //sf=new SecondFragment();
        datuak=new Datuak(view.getContext());
        produktuak=datuak.datuakItzuli();

        izena= (TextView) getView().findViewById(R.id.textViewIzenaInfo);
        kategoria=(TextView)getView().findViewById(R.id.textViewKategoriaInfo);
        prezioa=(TextView) getView().findViewById(R.id.textViewPrezioaInfo);

        izena.setText(produktuak.get(0).getIzena());
        kategoria.setText(produktuak.get(0).getCategory());
        prezioa.setText(String.valueOf(produktuak.get(0).getPrezio())+" €");

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

}