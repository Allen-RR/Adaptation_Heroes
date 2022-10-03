package dev.hardsoft.adaptationheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Next_Mission extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_mission);
    }
    public void Finalizar(View view){
        Intent i = new Intent(Next_Mission.this, Inicio.class);
        startActivity(i);
    }
}