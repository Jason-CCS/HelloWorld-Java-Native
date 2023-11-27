package com.jason;

/**
 * HackRank
 */
public class Winner {
    public static String winner(String erica, String bob) {
        int eSum = 0;
        int bSum = 0;

        for (int i = 0; i < erica.length(); i++) {
            eSum = eSum + score(erica.charAt(i));
            bSum = bSum + score(bob.charAt(i));
        }

        if (eSum > bSum)
            return "Erica";
        else if (eSum == bSum)
            return "tie";
        else
            return "Bob";
    }

    public static int score(char c) {
        int score = 0;
        switch (c) {
            case 'E':
                score = 1;
                break;
            case 'M':
                score = 3;
                break;
            case 'H':
                score = 5;
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(winner("EHH", "EME"));
    }
}
