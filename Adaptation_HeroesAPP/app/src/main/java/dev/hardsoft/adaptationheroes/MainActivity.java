package dev.hardsoft.adaptationheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Pair;
import android.widget.ImageButton;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Card card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Map<String, Integer> pool = new HashMap<String, Integer>();
        //Map<String, Integer> prime = new HashMap<String, Integer>();
        // Change Card id to int
        /**int poolSize = 5;
        int organismCards = 2;
        int[][] pool = new int[poolSize][2];
        int[][] prime = new int[organismCards+1][2];

        GeneticAlgorithm gA = new GeneticAlgorithm();
        prime = gA.geneticAlgorithm(pool);*/

        System.out.println("Start");
        int poolSize = 5;
        int organismCards = 3;
        int[][] pool = new int[poolSize][2];
        int[][] prime = new int[organismCards+1][2];

        // Populate test values
        for(int i = 0; i<poolSize; i++){
            pool[i][0] = i;
            pool[i][1] = i;
        }

        GeneticAlgorithm gA = new GeneticAlgorithm();
        prime = gA.geneticAlgorithm(pool);

        System.out.println("Prime:");
        for (int i = 0; i < prime.length; i++)
            for (int j = 0; j < prime[i].length; j++)
                System.out.print(prime[i][j] + " ");
    }
}