package dev.hardsoft.adaptationheroes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SuperPowers extends AppCompatActivity {
    private LinearLayout lcard1;
    private Boolean is_checked = false;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;
    private Card card6;
    //private ArrayList<String> Cards = new ArrayList<>();
    private TextView txtCard1;
    private TextView txtCard2;
    private TextView txtCard3;
    private TextView txtCard4;
    private TextView txtCard5;
    private TextView txtCard6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_powers);

    }
    public void carta1(View view){
        txtCard1 = findViewById(R.id.txtcard1);
        lcard1 = findViewById(R.id.lcard1);
        lcard1.setBackgroundColor(Color.GREEN);
        is_checked = true;
        String texto = (String) txtCard1.getText();
        compile(texto);
        Integer Id = card1.getId();
        Integer points = card1.getValue();
    }
    public void carta2(View view){
        txtCard1 = findViewById(R.id.txtcard2_1);
        lcard1 = findViewById(R.id.lcard1);
        lcard1.setBackgroundColor(Color.GREEN);
        is_checked = true;
        String texto = (String) txtCard1.getText();
        compile(texto);
        Integer Id = card2.getId();
        Integer points = card2.getValue();

    }
    public void carta3(View view){
        txtCard1 = findViewById(R.id.txtcard3_1);
        lcard1 = findViewById(R.id.lcard1);
        lcard1.setBackgroundColor(Color.GREEN);
        is_checked = true;
        String texto = (String) txtCard1.getText();
        compile(texto);
        Integer Id = card3.getId();
        Integer points = card3.getValue();

    }
    public void carta4(View view){
        txtCard1 = findViewById(R.id.txtcard4);
        lcard1 = findViewById(R.id.lcard1);
        lcard1.setBackgroundColor(Color.GREEN);
        is_checked = true;
        String texto = (String) txtCard1.getText();
        compile(texto);
        Integer Id = card4.getId();
        Integer points = card4.getValue();

    }
    public void carta5(View view){
        txtCard1 = findViewById(R.id.txtcard5);
        lcard1 = findViewById(R.id.lcard1);
        lcard1.setBackgroundColor(Color.GREEN);
        is_checked = true;
        String texto = (String) txtCard1.getText();
        compile(texto);
        Integer Id = card5.getId();
        Integer points = card5.getValue();

    }
    public void carta6(View view){
        txtCard1 = findViewById(R.id.txtcard6);
        lcard1 = findViewById(R.id.lcard1);
        lcard1.setBackgroundColor(Color.GREEN);
        is_checked = true;
        String texto = (String) txtCard1.getText();
        compile(texto);
        Integer Id = card6.getId();
        Integer points = card6.getValue();

    }




    public void compile(String text){

        switch(text){
            case "Warm":
                card1 = new Card(1,"Warm",30);
                break;
            case "Rat":
                card2 = new Card(2,"Rat",50);
                break;
            case "Insect":
                card3= new Card(3,"Insect",25);
                break;
            case "Plant":
                card4 = new Card(4,"Plant",35);
                break;
            case "Drosophila":
                card5= new Card(5,"Drosophila",65);
                break;
            case "Fish":
                card6 = new Card(6,"Fish",28);
                break;
            default:
                Toast.makeText(this, "Hubo un error", Toast.LENGTH_SHORT).show();

        }


    }
    public void get_cards(Integer id, Integer value){}
    public void boton(View view){
        Toast.makeText(this, "boton",Toast.LENGTH_SHORT).show();

    }

}