package com.jason.array_and_string;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        int index = 0;
        List<StringBuilder> sbList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            sbList.add(new StringBuilder());
        }

        while (index < s.length()) {
            for (int zig = 0; zig < numRows && index < s.length(); zig++) {
                sbList.get(zig).append(s.charAt(index));
                index++;
            }
            for (int zag = numRows - 2; zag >= 1 && index < s.length(); zag--) {
                sbList.get(zag).append(s.charAt(index));
                index++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : sbList) {
            result.append(sb.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 4));
    }
}
