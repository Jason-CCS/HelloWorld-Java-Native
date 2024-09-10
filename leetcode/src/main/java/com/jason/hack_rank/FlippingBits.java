package com.jason.hack_rank;

public class FlippingBits {

    /**
     * at least O(3n).
     * @param n
     * @return
     */
    public static long flippingBits(long n) {
        // Write your code here
        String binaryString = String.format("%32s", Long.toBinaryString(n)).replace(' ', '0');
        binaryString = binaryString.replace('0', '2').replace('1', '0').replace('2', '1');
        return Long.parseLong(binaryString, 2);
    }

    public static void main(String[] args) {
        System.out.println(flippingBits(9L));
    }
}
