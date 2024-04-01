package com.jason.hack_rank;

public class FizzBuzz {
    public static void fizzBuzz(int n) {
        for (int i = 0; i <= n; i++) {
            match(i);
        }
    }

    public static void match(int n) {
        if (n % 3 == 0 && n % 5 == 0)
            System.out.println("FizzBuzz");
        else if (n % 3 == 0)
            System.out.println("Fizz");
        else if (n%5==0)
            System.out.println("Buzz");
        else
            System.out.println(n);
    }



}
