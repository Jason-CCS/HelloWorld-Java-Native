package com.jason.hack_rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SparseArrays {

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        HashMap<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (String query : queries) {
            int occurrences = map.get(query) != null ? map.get(query) : 0;
            result.add(occurrences);
        }

        return result;
    }

}
