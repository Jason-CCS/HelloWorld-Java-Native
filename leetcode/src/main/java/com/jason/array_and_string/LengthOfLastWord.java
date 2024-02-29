package com.jason.array_and_string;

/**
 * This one is quite easy. Go from the tail is faster but rather tricky.
 * Use s.trim().split(" ")[length-1].length is more general and easier to understand.
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int theLastCharIndex = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (theLastCharIndex == 0 && s.charAt(i) != ' ') {
                theLastCharIndex = i;
            }
            if (theLastCharIndex != 0 && s.charAt(i) == ' ') {
                return theLastCharIndex - i;
            }
        }

        return theLastCharIndex + 1;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
        System.out.println(lengthOfLastWord("a"));
    }
}
