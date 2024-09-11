package com.jason.divide_and_conquer;

import java.util.*;

/**
 * Problem: 973
 * Difficulty: Medium
 */
public class KClosestPointsToOrigin {
    /**
     * My approach. O(n*log(n)).
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {
        if (k >= points.length) {
            return points;
        }

        PriorityQueue<Point> maxHeap = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Double.compare(o2.distance, o1.distance); // reverse
            }
        });

        for (int i = 0; i < points.length; i++) {
            double d = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
            if (maxHeap.size() == k) {
                if (d < maxHeap.peek().distance) {
                    maxHeap.poll();
                    maxHeap.offer(new Point(d, i));
                }
            } else {
                maxHeap.offer(new Point(d, i));
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[maxHeap.poll().idx];
        }

        return result;
    }

    static class Point {
        double distance;
        int idx;

        public Point(double distance, int idx) {
            this.distance = distance;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin s = new KClosestPointsToOrigin();
        int[][] result = s.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);
        // the output should be [[-2, 2]]
        System.out.println(Arrays.deepToString(result));
    }
}
