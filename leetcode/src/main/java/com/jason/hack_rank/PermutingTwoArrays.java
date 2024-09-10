package com.jason.hack_rank;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutingTwoArrays {
    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // Write your code here
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) + B.get(i) < k) {
                return "NO";
            }
        }

        return "YES";
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer comp;
        for (int i = 0; i < nums.length; i++) {
            comp = map.get(target - nums[i]);
            if (null != comp) {
                return new int[]{comp, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
