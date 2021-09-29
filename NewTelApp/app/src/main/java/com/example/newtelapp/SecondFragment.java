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
        TextView tx= (TextView) getView().findViewById(R.id.textViewIzenaInfo);
        tx.setText(produktuak.get(0).getIzena());

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