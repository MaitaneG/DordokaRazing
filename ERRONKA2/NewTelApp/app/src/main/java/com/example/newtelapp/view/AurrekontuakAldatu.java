package com.example.newtelapp.view;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newtelapp.R;

public class AurrekontuakAldatu extends AppCompatActivity {
    private ImageButton irten;
    private ImageButton gorde;

    /**
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aurrekontuak_aldatu_layout);
        hasieratu(); // Konponenteak hasieratu
    }

    private void hasieratu() {
        //irten=findViewById(R.id);
        //gorde=findViewById(R.id);
    }
}
