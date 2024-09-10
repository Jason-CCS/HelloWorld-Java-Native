package com.jason.hack_rank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class JesseAndCookies {
    public static int times = 0;

    /**
     * This solution is TLE.
     * This solution is O(times*n)
     *
     * @param k
     * @param A
     * @return
     */
    public static int cookies1(int k, List<Integer> A) {
        // Write your code here
        if (!(A instanceof ArrayList))
            A = new ArrayList<>(A);

        Integer firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (Integer curValue : A) {
            if (curValue < secondMin) {
                secondMin = curValue;
                if (secondMin < firstMin) {
                    int tmp = firstMin;
                    firstMin = secondMin;
                    secondMin = tmp;
                }
            }
        }
        if (firstMin < k) { // want to mix
            times++;
            int newCookie = firstMin + 2 * secondMin;
            A.remove(firstMin);
            A.remove(secondMin);
            A.add(newCookie);
            if (A.size() == 1 && newCookie < k)
                return -1;
        } else {
            return times;
        }

        return cookies1(k, A);
    }

    /**
     * Heapify only takes O(n)
     *
     * @param k
     * @param A
     * @return
     */
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(A);
        int times = 0;
        while (!pq.isEmpty() && pq.peek() < k) {
            if (pq.size() == 1)
                return -1;
            int newCookie = pq.poll() + pq.poll() * 2;
            times++;
            pq.offer(newCookie);
        }

        return times;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(cookies(10, Arrays.asList(52, 96, 13, 37)));
//        PriorityQueue<Integer> pq = new PriorityQueue<>(List.of(2, 7, 3, 6, 4, 6));
//        System.out.println(pq.poll());
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .toList();
    }
}
