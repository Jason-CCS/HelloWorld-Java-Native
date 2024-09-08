package com.jason.hack_rank;

/**
 * 這題不錯，原本以為只能O(n^2)，最後還是被我想出O(n)的解.
 */
public class PalindromeIndex {
    public static int palindromeIndex(String s) {
        // Write your code here
        // filter out all the string that is palindrome already.
        if (isPalindrome(s))
            return -1;
        // s is definitely not a palindrome.
        return palindromeIndexBySkippingOnce(s);
    }


    public static boolean isPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        while (leftPointer < rightPointer) {
            if (s.charAt(leftPointer) != s.charAt(rightPointer))
                return false;
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    public static int palindromeIndexBySkippingOnce(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        while (leftPointer < rightPointer) {
            if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
                break;
            }
            leftPointer++;
            rightPointer--;
        }
        if (isPalindrome(s.substring(leftPointer + 1, rightPointer + 1))) {
            return leftPointer;
        }
        if (isPalindrome(s.substring(leftPointer, rightPointer))) {
            return rightPointer;
        }

        return -1;
    }

    //fgnfnidynhxebxxxfmxixhsruldhsaobhcggchboashdlurshxixmfxxxbexhnydinfngf
    public static void main(String[] args) {
//        System.out.println(palindromeIndex("a"));
//        System.out.println(palindromeIndex("aa"));
//        System.out.println(palindromeIndex("aaa"));
//        System.out.println(palindromeIndex("abaa"));
//        System.out.println(palindromeIndex("aaba"));
//        System.out.println(palindromeIndex("abaaa"));
//        System.out.println(palindromeIndex("aaaba"));
//        System.out.println(palindromeIndex("azabbahhh"));
        System.out.println(palindromeIndex("hgygsvlfcwns1wtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh"));
        System.out.println(palindromeIndex("fgnfnidynhxebxxxfmxixhsruldhsaobhcggchboashdlurs1hxixmfxxxbexhnydinfngf"));
        System.out.println(palindromeIndex("bsyhvwfuesumsehmytqioswpcbxyolapfywdxeacyuruybhbwxjmrrmjxwbhbyuruycaexdwyfpaloyxbcpwsoi1qtymhesmuseufwvhysb"));
        System.out.println(palindromeIndex("fvyqxqxynewuebtcuqdwyetyqisappmunmnldmkttkmdlnmnumppasiqyteywdquctbeuwenyxqxqy1vf"));
        System.out.println(palindromeIndex("mmbiefhflbeckaecprwfgmqlydfroxrblulpasumubqhbvlqpixvvxipqlvbhqbumusaplulbrxorfdylqmgfwrpceakceblfhfeib1mm"));
        System.out.println(palindromeIndex("tpqknkmbgasitnwqrqasolmevkasccsakvemlosaqrqwntisagbmknk1qpt"));
        System.out.println(palindromeIndex("prcoitfiptvcxroalqmfpnqyhrubxspplrftomfehbbhefmotfrlppsxburhyqnpfmqlaorxcvtpiftio1crp"));
        System.out.println(palindromeIndex("kjowoemiduaaxasnqghxbxkiccikxbxhgqnsaxaaudimeowo1jk"));
    }

}
