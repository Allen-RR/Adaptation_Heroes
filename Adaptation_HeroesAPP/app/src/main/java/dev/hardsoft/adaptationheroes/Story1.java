package dev.hardsoft.adaptationheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Story1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story1);
    }
    public void btn_Play(View view){
        Intent i = new Intent(Story1.this, Story2.class);
        startActivity(i);
    }
}