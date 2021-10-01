package com.example.newtelapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.newtelapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ImageButton irten_botoia;
    private ImageButton erakutsi_produktuak_botoia;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        erakutsi_produktuak_botoia=view.findViewById(R.id.button_erakutsi_produktuak);
        irten_botoia=view.findViewById(R.id.button_irten);

        erakutsi_produktuak_botoia.setOnClickListener(this::bestePantilaraJoan);

        irten_botoia.setOnClickListener(this::itxi);

    }

    public void bestePantilaraJoan(View view){
        NavHostFragment.findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment);
    }

    public void itxi(View view){
        new AlertDialog.Builder(getContext()).setTitle("Aplikazioa ixten").setMessage("Aplikazioa itxi nahi duzu?").setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("mensaje","se cancelo la acción");
            }
        }).show();


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}