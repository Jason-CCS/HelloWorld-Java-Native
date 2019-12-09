package com.jason.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();


        return 0.0;
    }

    private LinkedList<Integer> sortTwoArray(int[] nums1, int[] nums2) {
        LinkedList<Integer> resultList = new LinkedList<>();
        int midIndex1 = nums1.length / 2; // get floor when length is odd number
        int midIndex2 = nums2.length / 2;
        int midNum1 = nums1[midIndex1 / 2];
        int midNum2 = nums2[midIndex2 / 2];
        int topMidNumNow = midNum1;
        resultList.addLast(topMidNumNow);

        // start compare
        if (midNum2 < topMidNumNow) {
            int pos = getNearestPosition(nums1, 0, 0, midNum2);
            if(midNum2 <= nums1[pos]){
                resultList.addFirst(midNum2);
//                LinkedList<Integer> leftList= sortTwoArray(Arrays.copyOfRange(nums1, 0, ))
            }

        } else if (midNum2 > topMidNumNow) {

        } else {
            // midNum2 == topMidNumNow

        }


        return null;
    }

    private int getNearestPosition(int[] numAry, int startPos, int endPos, int comparingTarget) {
        if(startPos == endPos){
            return startPos;
        }
        int midIndex = (startPos + endPos) / 2;
        if(comparingTarget < numAry[midIndex]){
            return getNearestPosition(numAry, startPos, midIndex-1, comparingTarget);
        }else if(comparingTarget > numAry[midIndex]){
            return getNearestPosition(numAry, midIndex + 1, endPos, comparingTarget);
        }else{
            // comparingTarget == numAry[midIndex]
            return midIndex;
        }
    }
}


class Node {
    int index;
    int[] array;
    Node parent;
    Node leftChild;
    Node rightChild;

    void putAtRight(Node child) {
        if (this.rightChild == null) {
            this.rightChild = child;
        }
    }

    void putAtLeft(Node node) {

    }
}
