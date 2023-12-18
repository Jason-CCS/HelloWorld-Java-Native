package com.jason.hack_rank;

import java.util.*;

/**
 * HackRank
 */
public class SmallestNegativeBalance {
    public static List<String> smallestNegativeBalance(List<List<String>> debts) {
        // Write your code here
        List<String> negativeBalanceList = new ArrayList<>();
        HashMap<String, Integer> balanceMap = new HashMap<>();
        for (List<String> record : debts) {
            String borrower = record.get(0);
            String lender = record.get(1);
            int amount = Integer.parseInt(record.get(2));
            if (balanceMap.containsKey(borrower)) {
                balanceMap.put(borrower, balanceMap.get(borrower) - amount);
            } else {
                balanceMap.put(borrower, -amount);
            }
            if (balanceMap.containsKey(lender)) {
                balanceMap.put(lender, balanceMap.get(lender) + amount);
            } else {
                balanceMap.put(lender, amount);
            }
        }
        System.out.println(balanceMap);

        int minBalance = 0;
        for (Map.Entry<String, Integer> e : balanceMap.entrySet()) {
            if (e.getValue() == minBalance)
                negativeBalanceList.add(e.getKey());
            if (e.getValue() < minBalance) {
                minBalance =e.getValue();
                negativeBalanceList.clear();
                negativeBalanceList.add(e.getKey());
            }
        }

        if (negativeBalanceList.isEmpty()) {
            negativeBalanceList.add("Nobody has a negative balance");
            return negativeBalanceList;
        }
        Collections.sort(negativeBalanceList);
        return negativeBalanceList;
    }

    public static void main(String[] args) {
        List<String> r1 = Arrays.asList("Alex", "Blake", "2");
        List<String> r2 = Arrays.asList("Blake", "Alex", "2");
        List<String> r3 = Arrays.asList("Casey", "Alex", "5");
        List<String> r4 = Arrays.asList("Blake", "Casey", "7");
        List<String> r5 = Arrays.asList("Alex", "Blake", "4");
        List<String> r6 = Arrays.asList("Alex", "Casey", "4");
        List<String> r7 = Arrays.asList("Casey", "Dan", "8");

        List<List<String>> debts = new ArrayList<>(Arrays.asList(r1, r2, r3, r4, r5, r6, r7));

        System.out.println(smallestNegativeBalance(debts));
    }
}
