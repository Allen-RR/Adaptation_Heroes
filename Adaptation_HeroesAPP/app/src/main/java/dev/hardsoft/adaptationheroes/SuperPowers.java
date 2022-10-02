package dev.hardsoft.adaptationheroes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SuperPowers extends AppCompatActivity {
    private LinearLayout lcard1;
    private LinearLayout lcard2;
    private LinearLayout lcard3;
    private LinearLayout lcard4;
    private LinearLayout lcard5;
    private LinearLayout lcard6;
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
    private int[][] usercards = new int[2][2];
    private boolean First = false;
    private boolean Second = false;
    private int[][] prime;
    private int score;
    private Button btn_fusion;



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
        set_cards(Id, points);

    }
    public void carta2(View view){
        txtCard2 = findViewById(R.id.txtcard2_1);
        lcard2 = findViewById(R.id.lcard2);
        lcard2.setBackgroundColor(Color.GREEN);
        is_checked = true;
        String texto = (String) txtCard2.getText();
        compile(texto);
        Integer Id = card2.getId();
        Integer points = card2.getValue();
        set_cards(Id, points);

    }
    public void carta3(View view){
        txtCard3 = findViewById(R.id.txtcard3_1);
        lcard3 = findViewById(R.id.lcard3);
        lcard3.setBackgroundColor(Color.GREEN);
        is_checked = true;
        String texto = (String) txtCard3.getText();
        compile(texto);
        Integer Id = card3.getId();
        Integer points = card3.getValue();
        set_cards(Id, points);


    }
    public void carta4(View view){
        txtCard4 = findViewById(R.id.txtcard4);
        lcard4 = findViewById(R.id.lcard4);
        lcard4.setBackgroundColor(Color.GREEN);
        is_checked = true;
        String texto = (String) txtCard4.getText();
        compile(texto);
        Integer Id = card4.getId();
        Integer points = card4.getValue();
        set_cards(Id, points);


    }
    public void carta5(View view){
        txtCard5 = findViewById(R.id.txtcard5);
        lcard5 = findViewById(R.id.lcard5);
        lcard5.setBackgroundColor(Color.GREEN);
        is_checked = true;
        String texto = (String) txtCard5.getText();
        compile(texto);
        Integer Id = card5.getId();
        Integer points = card5.getValue();
        set_cards(Id, points);


    }
    public void carta6(View view){
        txtCard6 = findViewById(R.id.txtcard6);
        lcard6 = findViewById(R.id.lcard6);
        lcard6.setBackgroundColor(Color.GREEN);
        is_checked = true;
        String texto = (String) txtCard6.getText();
        compile(texto);
        Integer Id = card6.getId();
        Integer points = card6.getValue();
        set_cards(Id, points);

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
    public void set_cards(Integer id, Integer points){


        if (!First){
             usercards[0][0] = id;
             usercards[0][1] = points;
             First = true;
        }else if(!Second){
            usercards[1][0] = id;
            usercards[1][1] = points;
            Second = true;


        }
        else{
            Toast.makeText(this, "Haz escogido el máximo de cartas", Toast.LENGTH_SHORT).show();
        }


    }
    public void boton(View view){


    }
    public void botonfusion(View view){

        int poolSize = 15;
        int organismCards = 7;
        int[][] pool = new int[poolSize][2];
        prime = new int[organismCards+1][2];


        // Populate test values
        for(Integer i = 0; i<2; i++){
            for(Integer j = 0; j<2;j++){
                pool[i][j] = usercards[i][j];
            }
        }
        for(int i = 2; i<poolSize; i++){
            pool[i][0] = i+5;
            pool[i][1] = i+5;
        }

        GeneticAlgorithm gA = new GeneticAlgorithm();
        prime = gA.geneticAlgorithm(pool);
        //System.out.println(prime.length);


        //for (int i = 0; i < prime.length; i++)
            //for (int j = 0; j < prime[i].length; j++)
        score = prime[0][1];
        int gravityRisk = 2*2;
        score -= gravityRisk;
        if (score>146){
            Intent i1 = new Intent(SuperPowers.this, YouWin.class);
            startActivity(i1);
        }else{
            Intent i2 = new Intent(SuperPowers.this, YouFail.class);
            startActivity(i2);
        }
    }



}