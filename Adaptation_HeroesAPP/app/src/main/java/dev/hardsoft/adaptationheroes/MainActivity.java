package dev.hardsoft.adaptationheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Map<Integer, String> = new HashMap<Integer, String>();
    Card[] prime = new Card[2]; // Prime organism with best value
    //prime[] = geneticAlgorithm();


}

