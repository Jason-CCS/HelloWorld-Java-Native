package com.jason.design;

import java.util.*;

/**
 * Problem: 380
 * Difficulty: Medium
 * This class provides a data structure for adding, removing, and choosing a random element in O(1) time complexity.
 */
public class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    /**
     * Here is the key point.
     * if the index removed from map is not the last index in the list, we use the real last element in list to
     * make up the removed vacancy. So here you can see list.set(index, lastVal) and map.put(lastVal, index).
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        else {
            int index = map.remove(val);
            if (index != list.size() - 1){
                int lastVal = list.get(list.size() - 1);
                list.set(index, lastVal);
                map.put(lastVal, index);
            }
            list.remove(list.size() - 1);
            return true;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.remove(0));
        System.out.println(rs.remove(0));
        System.out.println(rs.insert(0));
        System.out.println(rs.getRandom());
        System.out.println(rs.remove(0));
        System.out.println(rs.insert(0));
    }
}
