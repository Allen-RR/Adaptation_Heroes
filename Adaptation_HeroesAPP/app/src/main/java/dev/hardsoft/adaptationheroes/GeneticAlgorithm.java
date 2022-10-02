package dev.hardsoft.adaptationheroes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GeneticAlgorithm {
    public static int poolSize;
    public static int organismCards = 2; // Adaptable
    public static int population = 3; // Adaptable
    public static int cycles = 100; // Adaptable
    static Map<String, Integer> pool = new HashMap<String, Integer>();
    static Map<String, Integer> organism = new HashMap<String, Integer>();
    static Map<String, Integer> prime = new HashMap<String, Integer>();

    public static Map<String, Integer> geneticAlgorithm(Map<String, Integer> p) {
        pool = p;
        poolSize = pool.size();
        List<Map<String, Integer>> generation = new ArrayList<Map<String, Integer>>();

        // Gets random element from pool
        Random random = new Random();
        List<String> keys = new ArrayList<String>(pool.keySet());
        for (int i = 0; i<population; i++){
            organism.clear();
            for (int j = 0; j<organismCards; j++){
                String randomKey = keys.get( random.nextInt(keys.size()) );
                Integer value = pool.get(randomKey);
                organism.put(randomKey, value);

            }
        }
        //organism.entrySet()
        //generation.add()

        return prime;
    }
}
