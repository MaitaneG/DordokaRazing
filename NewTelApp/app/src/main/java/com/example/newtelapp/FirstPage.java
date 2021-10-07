package com.example.newtelapp;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class FirstPage extends AppCompatActivity {

    private ImageButton irten_botoia;
    private ImageButton erakutsi_produktuak_botoia;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        erakutsi_produktuak_botoia = findViewById(R.id.button_erakutsi_produktuak);
        erakutsi_produktuak_botoia.setOnClickListener(this::bestePantilaraJoan);
        irten_botoia = findViewById(R.id.button_irten);
        irten_botoia.setOnClickListener(this::itxi);
    }

    public void bestePantilaraJoan(View view){
        Intent myIntent = new Intent(view.getContext(), SecondPage.class);
        ActivityOptions options=ActivityOptions.makeCustomAnimation(this,R.anim.to_right, R.anim.to_right);
        this.startActivity(myIntent, options.toBundle());
    }

    public void itxi(View view){
        new AlertDialog.Builder(this)
                .setTitle("Aplikazioa ixten ")
                .setMessage("Aplikazioa itxi nahi duzu?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                        if (getIntent().getBooleanExtra("EXIT", true)) {
                            finish();
                            System.exit(0);
                        }
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();


    }
}