package dev.hardsoft.adaptationheroes;

import android.os.Build;

//import java.util.Arrays;
import java.util.Random;

public class GeneticAlgorithm {
    //public  String adaptabilityKey = "Adaptability";
    //public int adaptabilityValue = -1;
    public int poolSize = 15; // Adaptable
    public int organismCards = 7; // Adaptable
    public int populationSize = 10; // Adaptable
    public int cycles = 50; // Adaptable
    public int anyOrganism = 0;
    public int primeAdaptability = 0;
    public int worstAdaptability = 0;
    public int primeIndex = 0;
    public int worstIndex = 0;
    Random random = new Random(); // Gets random element from pool
    int[][] pool = new int[poolSize][2];
    int[][] organism = new int[organismCards+1][2];
    int[][] prime = new int[organismCards+1][2];
    int[][][] generation = new int[populationSize][organismCards+1][2];
    int[][][] newGeneration = new int[populationSize][organismCards+1][2];

    public int[][] geneticAlgorithm(int[][] p) {
        pool = p;
        for (int n = 0; n < cycles; n++) {
            //Arrays.fill(newGeneration, null);
            newGeneration = new int[populationSize][organismCards+1][2];
            for (int i = 0; i < populationSize; i++) { // Generate population
                //Arrays.fill(organism, null);
                organism = new int[organismCards+1][2];
                for (int j = 1; (j <= organismCards) && (n==0); j++) { // Make organism
                    anyOrganism = random.nextInt(poolSize);
                    organism[0][0] = -1;
                    organism[0][1] += pool[anyOrganism][1]; // Calculate the adaptability value
                    organism[j][0] = pool[anyOrganism][0];
                    organism[j][1] = pool[anyOrganism][1];
                    //anyOrganism = random.nextInt(poolSize);
                }
                if(organism[0][1] > primeAdaptability){
                    prime = organism;
                    primeAdaptability = organism[0][1];
                    primeIndex = i;
                }else if(organism[0][1] < worstAdaptability) {
                    worstAdaptability = organism[0][1];
                    worstIndex = i;
                }
                generation[i] = organism;
            }
            // Reproduce the population, generates new individuals
            for (int j = 0; j < populationSize; j++) {
                for(int k = 1; k <= organismCards; k++) { // Make new individual (best parent)
                    anyOrganism = random.nextInt(populationSize);
                    if(k-1<(int)organismCards/2) {
                        if(j==0){
                            newGeneration[0][k][0] = generation[primeIndex][k][0];
                            newGeneration[0][k][1] = generation[primeIndex][k][1];
                            newGeneration[j][0][1] += generation[primeIndex][k][1]; // Calculate the adaptability value
                        }else if(j==1){
                            newGeneration[1][k][0] = generation[worstIndex][k][0];
                            newGeneration[1][k][1] = generation[worstIndex][k][1];
                            newGeneration[j][0][1] += generation[worstIndex][k][1]; // Calculate the adaptability value
                        }else{
                            newGeneration[j][k][0] = generation[anyOrganism][k][0];
                            newGeneration[j][k][1] = generation[anyOrganism][k][1];
                            newGeneration[j][0][1] += generation[anyOrganism][k][1]; // Calculate the adaptability value
                        }
                    }else{
                        newGeneration[j][k][0] = generation[anyOrganism][k][0];
                        newGeneration[j][k][1] = generation[anyOrganism][k][1];
                        newGeneration[j][0][1] += generation[anyOrganism][k][1]; // Calculate the adaptability value
                    }
                    newGeneration[j][0][0] = -1;
                    if(newGeneration[j][0][1] > primeAdaptability){
                        prime = newGeneration[j];
                        primeAdaptability = newGeneration[j][0][1];
                        primeIndex = j;
                    }else if(newGeneration[j][0][1] < worstAdaptability) {
                        worstAdaptability = newGeneration[j][0][1];
                        worstIndex = j;
                    }
                }
            }
            generation = newGeneration;
        }
        return prime;
    }
}
