package com.jason.bit;

/**
 * Problem: 67
 * Difficulty: Easy
 */
public class BitManipulation {

    /**
     * I can not use the Integer.parseInt(String, 2) to parse into the Integer.
     * The String input is too large to convert.
     * So for this problem, we can only operate them in char and String format.
     * Wherein StringBuilder.insert(offset, char),
     * the offset here I guess it is the position from the first char of the String.
     * So if we want to insert into the head of the String, we should always specify offset = 0.
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        StringBuilder sb = new StringBuilder();

        int indexA = charA.length - 1, indexB = charB.length - 1;
        char carrier = '0';
        while (indexA >= 0 || indexB >= 0 || carrier != '0') {
            if (indexA >= 0 && indexB >= 0) {
                Result result = add(carrier, charA[indexA], charB[indexB]);
                sb.insert(0, result.bit);
                carrier = result.carrier;
                indexA--;
                indexB--;
            } else if (indexA >= 0) {
                Result result = add(carrier, charA[indexA], '0');
                sb.insert(0, result.bit);
                carrier = result.carrier;
                indexA--;
            } else if (indexB >= 0) { // indexB < charB.length
                Result result = add(carrier, '0', charB[indexB]);
                sb.insert(0, result.bit);
                carrier = result.carrier;
                indexB--;
            } else {
                Result result = add(carrier, '0', '0');
                sb.insert(0, result.bit);
                carrier = result.carrier;
            }
        }

        return sb.toString();
    }

    public static Result add(char carrier, char up, char down) {
        if (carrier == '0') {
            if (up == '1' && down == '1')
                return new Result('1', '0');
            else if (up == '0' && down == '0')
                return new Result('0', '0');
            else
                return new Result('0', '1');
        } else {
            if (up == '1' && down == '1')
                return new Result('1', '1');
            else if (up == '0' && down == '0')
                return new Result('0', '1');
            else
                return new Result('1', '0');
        }
    }

    public static class Result {
        char carrier;
        char bit;

        public Result(char carrier, char result) {
            this.carrier = carrier;
            this.bit = result;
        }
    }

    public static void main(String[] args) {
        System.out.println(addBinary("111", "111111"));
    }
}
