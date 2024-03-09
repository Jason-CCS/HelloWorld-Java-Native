package com.jason.two_pointers;

import java.util.Arrays;
import java.util.List;

/**
 * This is the problem from Netscope manager.
 * Please move all the zeros of a random number array to the last.
 */
public class MoveZerosToTail {
    public static int[] moveZeros(int[] inputAry) {
        // use two pointer
        int left = 0, right = inputAry.length - 1;
        while (left < right) {
            while (inputAry[left] != 0) left++;
            while (inputAry[right] == 0) right--;

            if (left < right) {
                int tmp = inputAry[left];
                inputAry[left] = inputAry[right];
                inputAry[right] = tmp;
                left++;
                right--;
            }
        }

        return inputAry;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(moveZeros(new int[]{1, 2, 3, 0, 0, 5, 7, 1234, 230, 23487, 0, 273, 29, 0, 8347})));
    }
}
