package com.jason.hack_rank;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ErrorLogExtraction {
    public static List<List<String>> extractErrorLogs(List<List<String>> logs) {
        // Write your code here
        List<List<String>> result = new ArrayList<>();

        // pick up ERROR and CRITICAL only
        for (List<String> row : logs) {
            if (row.get(2).equals("ERROR") || row.get(2).equals("CRITICAL"))
                result.add(row);
        }

        result.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return compareDates(o1.get(0), o2.get(0), o1.get(1), o2.get(1));
            }
        });

        return result;
    }

    public static int compareDates(String date1, String date2, String time1, String time2) {
        // Split the strings into year, month, and day components
        String[] parts1 = date1.split("-");
        String[] parts2 = date2.split("-");

        String[] part3 = time1.split(":");
        String[] part4 = time2.split(":");


        // Compare year components
        int year1 = Integer.parseInt(parts1[2]);
        int year2 = Integer.parseInt(parts2[2]);
        if (year1 != year2) {
            return Integer.compare(year1, year2);
        }

        // Compare month components
        int month1 = Integer.parseInt(parts1[1]);
        int month2 = Integer.parseInt(parts2[1]);
        if (month1 != month2) {
            return Integer.compare(month1, month2);
        }

        // Compare day components
        int day1 = Integer.parseInt(parts1[0]);
        int day2 = Integer.parseInt(parts2[0]);
        if (day1 != day2) {
            return Integer.compare(day1, day2);
        }

        // Compare hour
        int hour1 = Integer.parseInt(part3[0]);
        int hour2 = Integer.parseInt(part4[0]);
        if (hour1 != hour2) {
            return Integer.compare(hour1, hour2);
        }

        // Compare hour
        int min1 = Integer.parseInt(part3[1]);
        int min2 = Integer.parseInt(part4[1]);
        return Integer.compare(min1, min2);
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("01"));
        System.out.println(Integer.parseInt("14"));
        System.out.println(Integer.compare(Integer.parseInt("01"), Integer.parseInt("14")));
    }
}
