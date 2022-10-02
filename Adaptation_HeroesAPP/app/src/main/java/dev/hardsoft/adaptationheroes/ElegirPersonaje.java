package dev.hardsoft.adaptationheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ElegirPersonaje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_personaje);
    }
    public void btn_Escoger(View view){
        Intent i = new Intent(ElegirPersonaje.this, Story1.class);
        startActivity(i);
    }
}