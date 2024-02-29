package com.jason.two_pointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String newString = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int leftPointer = 0;
        int rightPointer = newString.length() - 1;
        while (leftPointer < rightPointer) {
            if (newString.charAt(leftPointer) != newString.charAt(rightPointer))
                return false;
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
        System.out.println(new ValidPalindrome().isPalindrome(" "));

    }
}
