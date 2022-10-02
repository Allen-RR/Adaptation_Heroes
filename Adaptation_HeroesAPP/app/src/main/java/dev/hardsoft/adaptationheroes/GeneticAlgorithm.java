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
    //public int adaptabilityValue = -1;
    public int poolSize = 5; // Adaptable
    public int organismCards = 2; // Adaptable
    public int populationSize = 3; // Adaptable
    public int cycles = 10; // Adaptable
    public int anyOrganism = 0;
    public int primeAdaptability = 0;
    public int worstAdaptability = 0;
    public int primeIndex = 0;
    public int worstIndex = 0;
    //static Map<String, Integer> pool = new HashMap<String, Integer>();
    //static Map<String, Integer> organism = new HashMap<String, Integer>();
    //static Map<String, Integer> prime = new HashMap<String, Integer>();
    int[][] pool = new int[poolSize][2];
    int[][] organism = new int[organismCards+1][2];
    int[][] prime = new int[organismCards+1][2];
    int[][][] generation = new int[populationSize][organismCards][2];
    int[][][] newGeneration = new int[populationSize][organismCards][2];

    public int[][] geneticAlgorithm(int[][] p) {
        pool = p;
        //List<Map<String, Integer>> generation = new ArrayList<Map<String, Integer>>();

        for (int n = 0; n < cycles; n++) {
            Arrays.fill(generation, null);
            Random random = new Random(); // Gets random element from pool
            anyOrganism = random.nextInt(poolSize);
            for (int i = 0; i < populationSize; i++) { // Generate population
                Arrays.fill(organism, null);

                for (int j = 1; j < organismCards; j++) { // Make organism
                    organism[0][0] = -1;
                    organism[0][1] += pool[anyOrganism][1]; // Calculate the adaptability value
                    organism[j][0] = pool[anyOrganism][0];
                    organism[j][1] = pool[anyOrganism][1];

                    if(organism[0][1] > primeAdaptability){
                        prime = organism;
                        primeAdaptability = organism[0][1];
                        primeIndex = j;
                    }else{
                        if(organism[0][1] < worstAdaptability) {
                            worstAdaptability = organism[0][1];
                            worstIndex = j;
                        }
                    }
                    anyOrganism = random.nextInt(poolSize);
                }

                generation[i] = organism;
            }
            // Reproduce the population, generates new individuals
            for (int j = 1; j < populationSize; j++) {
                for(int k = 0; k < organismCards; k++) { // Make new individual (best parent)
                    if(k<5) {
                        newGeneration[0][k][0] = generation[primeIndex][k][0];
                        newGeneration[0][k][1] = generation[primeIndex][k][1];
                    }else{
                        anyOrganism = random.nextInt(poolSize);
                        newGeneration[0][k][0] = generation[anyOrganism][k][0];
                        newGeneration[0][k][1] = generation[anyOrganism][k][1];
                    }
                }
                for(int k = 0; k < organismCards; k++) { // Make new individual (worst parent)
                    if(k<5) {
                        newGeneration[0][k][0] = generation[worstIndex][k][0];
                        newGeneration[0][k][1] = generation[worstIndex][k][1];
                    }else{
                        anyOrganism = random.nextInt(poolSize);
                        newGeneration[0][k][0] = generation[anyOrganism][k][0];
                        newGeneration[0][k][1] = generation[anyOrganism][k][1];
                    }

                }
                for(int k = 0; k < organismCards; k++) { // Make new individual (average parents)
                    if(k<5) {
                        newGeneration[j][k][0] = generation[j][k][0];
                        newGeneration[j][k][1] = generation[j][k][1];
                    }else{
                        anyOrganism = random.nextInt(poolSize);
                        newGeneration[j][k][0] = generation[anyOrganism][k][0];
                        newGeneration[j][k][1] = generation[anyOrganism][k][1];
                    }
                }
            }
            generation = newGeneration;
        }
        return prime;
    }
}
