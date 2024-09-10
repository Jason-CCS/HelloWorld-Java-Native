package com.jason.hack_rank;

public class TimeConversion {
    public static String timeConversion(String s) {
        // Write your code here
        String result;
        if (s.endsWith("AM")) {
            String[] splits = s.replace("AM", "").split(":");
            result = splits[0].replace("12", "00") + ":" + splits[1] + ":" + splits[2];
        } else {
            String[] splits = s.replace("PM", "").split(":");
            if (!splits[0].equals("12")) {
                splits[0] = String.valueOf(Integer.parseInt(splits[0]) + 12);
            }
            result = splits[0] + ":" + splits[1] + ":" + splits[2];
        }

        return result;
    }
}
