package com.jason.hack_rank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlippingMatrix {

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int n = matrix.size()/2;
        int l = 2 * n - 1;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += Collections.max(Arrays.asList(matrix.get(i).get(j), matrix.get(l - i).get(j), matrix.get(i).get(l - j), matrix.get(l - i).get(l - j)));
            }
        }

        return sum;
    }
}
