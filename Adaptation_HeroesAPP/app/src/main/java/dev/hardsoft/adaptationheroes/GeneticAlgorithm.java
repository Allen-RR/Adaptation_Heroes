package dev.hardsoft.adaptationheroes;

import android.os.Build;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

public class GeneticAlgorithm {
    //public  String adaptabilityKey = "Adaptability";
    public  int adaptabilityValue = -1;
    public  int poolSize = 5; // Adaptable
    public  int organismCards = 2; // Adaptable
    public  int populationSize = 3; // Adaptable
    public  int cycles = 10; // Adaptable
    int anyOrganism = 0;
    //static Map<String, Integer> pool = new HashMap<String, Integer>();
    //static Map<String, Integer> organism = new HashMap<String, Integer>();
    //static Map<String, Integer> prime = new HashMap<String, Integer>();
    int[][] pool = new int[poolSize][2];
    int[][] organism = new int[organismCards+1][2];
    int[][] prime = new int[organismCards+1][2];
    int[][][] generation = new int[populationSize][organismCards][2];

    public int[][] geneticAlgorithm(int[][] p) {
        pool = p;
        //List<Map<String, Integer>> generation = new ArrayList<Map<String, Integer>>();

        for (int n = 0; n < cycles; n++) {
            Random random = new Random(); // Gets random element from pool
            anyOrganism = random.nextInt(poolSize);
            for (int i = 0; i < populationSize; i++) { // Generate population
                Arrays.fill(organism, null);

                for (int j = 1; j < organismCards; j++) { // Make organism

                    organism[0][0] = -1;
                    organism[0][1] += pool[anyOrganism][1]; // Calculate the adaptability value
                    organism[j][0] = pool[anyOrganism][0];
                    organism[j][1] = pool[anyOrganism][1];

                    anyOrganism = random.nextInt(poolSize);
                }

                generation[i] = organism;

                // Sort the generation

            }
            //organism.entrySet()
            //generation.add()
        }
        return prime;
    }
}
