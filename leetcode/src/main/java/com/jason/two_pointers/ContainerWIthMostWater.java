package com.jason.two_pointers;

/**
 * Problem: 11
 * Difficulty: Medium
 * Problem Description: This problem is to find two lines (represented as an array of integers), which, together with the x-axis forms a container, that can contain the most water.
 */
public class ContainerWIthMostWater {
    /**
     * This is my first version I can think of.
     * Time complexity: O(n^2), very bad solution.
     *
     * @param height
     * @return area
     */
    public static int maxArea1(int[] height) {
        int max = 0;
        int width;

        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                width = right - left;
                max = Math.max(max, width * Math.min(height[left], height[right]));
            }
        }

        return max;
    }

    /**
     * Second version from LeetCode.
     * This problem, the area is calculated by this equation: area(l,r) = width*height = abs(l-r)*min(h(l), h(r))
     * If we want to get larger area, we should enlarge either width or height.
     * However, the widest width is height[].length-1. we can only decrease the height to find larger height.
     * This is the only way we can possibly find larger area.
     * Thus, for the function min(h(l), h(r)) we should keep higher pointer on hold and move the lower pointer to
     * search for even higher pointer. <b>That's why we should give up the lower pointer.</b>
     * So that's it. This problem we should try to think the equation deeply, then it is possible to find the solution below.
     * Time complexity: O(n)
     *
     * @param height
     * @return maxArea
     */
    public static int maxArea2(int[] height) {
        int max = 0, left = 0, right = height.length - 1;

        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            max = Math.max(max, w * h);
            if (height[left] > height[right]) right--;
            else if (height[left] < height[right]) left++;
            else {
                left++;
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea1(new int[]{1, 1}));
        System.out.println(maxArea1(new int[]{2, 3, 4, 5, 18, 17, 6}));

        System.out.println(maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea2(new int[]{1, 1}));
        System.out.println(maxArea2(new int[]{2, 3, 4, 5, 18, 17, 6}));
    }
}
