package com.saurabh.practice.leetcode2026.medium.stringANDarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ImplementRandomizedSet {

    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random;

    public ImplementRandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {

        if(!map.containsKey(val))
            return false;

        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);


        list.set(index,lastElement);
        map.put(lastElement, index);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {

        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);

    }

    public static void main(String[] args) {
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, ++count);

        map.values().stream().forEach(v -> System.out.println(v));
    }
}
