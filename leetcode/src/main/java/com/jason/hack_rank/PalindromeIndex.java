package com.jason.hack_rank;

public class PalindromeIndex {

    public static int palindromeIndex(String s) {
        // Write your code here
        int res = -1;
        int idx = -1;
//        System.out.println(s);
        while (idx < s.length()) {
            if (isPalindrome(s, idx)) {
//                System.out.println(idx);
                return idx;
            }
            idx++;
        }

        return res;
    }

    public static boolean isPalindrome(String s, int skipIdx) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        while (leftPointer < rightPointer) {
            if (leftPointer == skipIdx) {
                leftPointer++;
                continue;
            }
            if (rightPointer == skipIdx) {
                rightPointer--;
                continue;
            }
            if (s.charAt(leftPointer) != s.charAt(rightPointer))
                return false;
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

//hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh
//fgnfnidynhxebxxxfmxixhsruldhsaobhcggchboashdlurshxixmfxxxbexhnydinfngf
//bsyhvwfuesumsehmytqioswpcbxyolapfywdxeacyuruybhbwxjmrrmjxwbhbyuruycaexdwyfpaloyxbcpwsoiqtymhesmuseufwvhysb
//fvyqxqxynewuebtcuqdwyetyqisappmunmnldmkttkmdlnmnumppasiqyteywdquctbeuwenyxqxqyvf
//mmbiefhflbeckaecprwfgmqlydfroxrblulpasumubqhbvlqpixvvxipqlvbhqbumusaplulbrxorfdylqmgfwrpceakceblfhfeibmm
//tpqknkmbgasitnwqrqasolmevkasccsakvemlosaqrqwntisagbmknkqpt
//prcoitfiptvcxroalqmfpnqyhrubxspplrftomfehbbhefmotfrlppsxburhyqnpfmqlaorxcvtpiftiocrp

//fgnfnidynhxebxxxfmxixhsruldhsaobhcggchboashdlurshxixmfxxxbexhnydinfngf
    public static void main(String[] args) {
//        System.out.println(palindromeIndex("a"));
//        System.out.println(palindromeIndex("aa"));
//        System.out.println(palindromeIndex("aaa"));
        System.out.println(isPalindrome("hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh", -1));
        System.out.println(isPalindrome("fgnfnidynhxebxxxfmxixhsruldhsaobhcggchboashdlurshxixmfxxxbexhnydinfngf", -1));
        System.out.println(isPalindrome("bsyhvwfuesumsehmytqioswpcbxyolapfywdxeacyuruybhbwxjmrrmjxwbhbyuruycaexdwyfpaloyxbcpwsoiqtymhesmuseufwvhysb", -1));
        System.out.println(isPalindrome("fvyqxqxynewuebtcuqdwyetyqisappmunmnldmkttkmdlnmnumppasiqyteywdquctbeuwenyxqxqyvf", -1));
        System.out.println(isPalindrome("mmbiefhflbeckaecprwfgmqlydfroxrblulpasumubqhbvlqpixvvxipqlvbhqbumusaplulbrxorfdylqmgfwrpceakceblfhfeibmm", -1));
        System.out.println(isPalindrome("tpqknkmbgasitnwqrqasolmevkasccsakvemlosaqrqwntisagbmknkqpt", -1));
        System.out.println(isPalindrome("prcoitfiptvcxroalqmfpnqyhrubxspplrftomfehbbhefmotfrlppsxburhyqnpfmqlaorxcvtpiftiocrp", -1));
        System.out.println(isPalindrome("kjowoemiduaaxasnqghxbxkiccikxbxhgqnsaxaaudimeowojk", -1));
    }

}
