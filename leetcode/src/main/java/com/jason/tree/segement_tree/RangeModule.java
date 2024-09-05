package com.jason.tree.segement_tree;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Problem: 715
 * Difficulty: Hard
 * The code in the editor is implementing a 'Range Module' which is a system that allows adding and potentially querying
 * and removing ranges. It is the solution to problem number 715, which is categorized under Hard difficulty level.
 */
public class RangeModule {
    private TreeMap<Integer, Integer> map;
    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if (right <= left) {
            return;
        }
        Integer start = map.floorKey(left); // if existing, it is the closest key to start but less than.
        Integer end = map.floorKey(right); // if not existing, it is less than all the key in tree.
        if (start == null && end == null) {
            // add a new range
            map.put(left, right);
        } else if (start != null && map.get(start) >= left) { // map.get(start) is 那個node的right，而map.get(start) >= left是最極端的例子，node.right==left有重疊。
            // is overlapped.
            map.put(start, Math.max(map.get(end), Math.max(map.get(start), right))); // example: TreeMap has {[1, 3), [5, 7], [11, 13)}, but addRange is [2, 9).
        } else { // if start is not a null, then end must not be a null.
            // left is not overlapped with map.get(start).
            map.put(left, Math.max(map.get(end), right)); // not sure where will left go.
        }

        // clean up intermediate intervals
        Map<Integer, Integer> subMap = map.subMap(left, false, right, true);// left不inclusive，因為是新加入的，不能刪。right在map.floorKey(right)找過merge過了，舊的要刪掉。
        Set<Integer> set = new HashSet<Integer>(subMap.keySet());
        map.keySet().removeAll(set);
    }

    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        if (start == null) {
            return false;
        }
        return map.get(start) >= right;
    }


    public void removeRange(int left, int right) {
        if (right <= left) {
            return;
        }
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if (end != null && map.get(end) > right) {
            map.put(right, map.get(end));
        }
        if (start != null && map.get(start) > left) {
            map.put(start, left);
        }

        // clean up intermediate intervals
        Map<Integer, Integer> subMap = map.subMap(left, true, right, false);
        Set<Integer> set = new HashSet<Integer>(subMap.keySet());
        map.keySet().removeAll(set);
    }

    public static void main(String[] args) {
        RangeModule rm = new RangeModule();
        rm.addRange(10, 20);
        rm.addRange(1, 3);
        rm.addRange(4, 6);
        rm.addRange(2, 10);
        rm.addRange(11, 13);
        rm.addRange(27, 28);
//        rm.addRange(13, 25);
        System.out.println(rm);
    }
}
