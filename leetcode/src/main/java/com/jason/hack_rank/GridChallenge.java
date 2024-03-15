package com.jason.hack_rank;

import java.util.Arrays;
import java.util.List;

/**
 * OK here I know Arrays utility has ability to sort, like list.sort(), Collections.sort().
 * And all the object extending Comparable has ability to do obj.compareTo(anotherObj).
 */
public class GridChallenge {

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        int m = grid.size();
        int n = grid.get(0).length();
        Character[][] charMatrix = new Character[m][n];
        for (int i = 0; i < m; i++) {
            String str = grid.get(i);
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray); // OK here I know Arrays util has ability to sort, like list.sort(), Collections.sort().
            for (int j = 0; j < n; j++) {
                charMatrix[i][j] = charArray[j];
            }
        }

        for (int j = 0; j < n; j++) {
            int i = 0;
            while (i < m) {
                if (i + 1 < m)
                    if (charMatrix[i][j].compareTo(charMatrix[i + 1][j]) > 0)
                        return "NO";
                i++;
            }
        }


        return "YES";
    }

    public static void main(String[] args) {
        System.out.println(gridChallenge(List.of("kc", "iu")));
    }
}
