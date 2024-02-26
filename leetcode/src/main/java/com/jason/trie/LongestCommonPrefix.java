package com.jason.trie;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs[0].length()==0)
            return "";
        boolean flag = true;
        String result = "";
        int index = 0;

        while (flag) {
            for (int i = 0; i < strs.length; i++) {
                if (i + 1 != strs.length)
                    flag = strs[i].charAt(index) == strs[i + 1].charAt(index);
                if (!flag)
                    return result;
            }
            result = result.concat(Character.toString(strs[0].charAt(index)));
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"a"}));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"apple","application","appier"}));
    }
}
