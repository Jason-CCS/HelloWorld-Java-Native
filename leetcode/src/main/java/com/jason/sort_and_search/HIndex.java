package com.jason.sort_and_search;

import java.util.Arrays;

/**
 * Problem: 273
 * Difficulty: Medium
 * This problem aims to calculate the HIndex of citation array.
 * Use the count sort approach.
 */
public class HIndex {

    /**
     * Version 1:
     * This solution is given by AI.
     * (n-i) means how many paper have more citations than citation[i].
     * Therefore, when citation[i]>=n-i, then we find the HIndex.
     *
     * Time Complexity: O(nlogn)+O(n)
     * @param citations
     * @return
     */
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }

    /**
     * Version 2:
     * This solution is inspired by counting sort.
     * Given citationCountArray to count up different citation numbers.
     * For example, citations=[1,3,1], then we have citationCountArray[1]=2.
     * This is because we have totally two papers have 1 citation.
     * <br>
     * And after the counting, we iterate from the end to the head
     * to find when sum of papers is greater than i,
     * which means at least so many papers having the citation number are greater than i (number of citations).
     * And we get the HIndex.
     * Time Complexity: O(n)+O(max)
     * @param citations
     * @return
     */
    public int hIndex2(int[] citations) {
        int max = 0;
        for (int citation : citations) {
            if (citation > max)
                max = citation;
        }
        int[] citationCountArray = new int[max + 1];
        for (int citation : citations) {
            citationCountArray[citation]++;
        }

        int sum = 0;
        int hIndex = 0;
        for (int i = citationCountArray.length - 1; i >= 0; i--) {
            sum = sum + citationCountArray[i];
            if (sum >= i) {
                hIndex = i;
                break;
            }
        }

        return hIndex;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex1(new int[]{3,0,6,1,5}));
        System.out.println(new HIndex().hIndex2(new int[]{3,0,6,1,5}));
    }
}
