package com.jason;

import java.util.ArrayList;
import java.util.List;

public class MoveZerosToTail {
    public static void main(String[] args) {
        int[] asdf = {1, 2};

        System.out.println(moveZeros(new int[]{1, 2, 3, 0, 0, 5}));
    }

    public static List<Integer> moveZeros(int[] numbers) {
        List<Integer> resultList = new ArrayList<>();
        List<Integer> zeroList = new ArrayList<>();
        for (int number : numbers) {
            if (number != 0) {
                resultList.add(number);
            } else {
                zeroList.add(0);
            }
        }

        resultList.addAll(zeroList);
        return resultList;
    }
}
