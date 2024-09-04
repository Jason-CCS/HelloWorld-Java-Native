package com.jason.hack_rank;

/**
 * 很好的題目可以訓練DP，但是太複雜了。
 * 這題訓練到了DP，尤其是有好幾層的DP，DP可以達到O(n)就算完的時間。
 * 而後再拿都只要O(1)，wp function就是這樣。
 * legoBlocks function這個寫法，告訴我以後不用省cache的空間，並且盡量使用array，這樣可以省去很多時間。
 * DP pattern:
 * if(cache[i]!=0) return cache[i];
 * cache[i] = computing logic if cache[i] does not exist.
 * return cache[i];
 */
public class LegoBlocks {
    private static long[] wpDP = new long[1001];
    private static final long modulo = 1_000_000_007;

    /**
     * O(n) if n>=5
     *
     * @param w
     * @return
     */
    private static long wp(int w) {
        if (w == 1) return 1;
        if (w == 2) return 2;
        if (w == 3) return 4;
        if (w == 4) return 8;
        if (wpDP[w] != 0) return wpDP[w];

        long permutations = wp(w - 1) + wp(w - 2) + wp(w - 3) + wp(w - 4);
        permutations %= modulo;

        wpDP[w] = permutations;
        return permutations;
    }

    /**
     * 雖然時間複雜度是O(m*n)，但是access的是基本型別陣列，沒有其他操作，可能這樣超級快。
     * @param n
     * @param m
     * @return
     */
    private static int legoBlocks(int n, int m) {
        long[] total = new long[m + 1];

        // O(m*n)
        for (int i = 1; i <= m; i++) {
            total[i] = 1;
            for (int j = 1; j <= n; j++) {
                total[i] *= wp(i);
                total[i] %= modulo;
            }
        }

        long[] good = new long[m + 1];
        long[] bad = new long[m + 1];
        good[1] = 1;
        bad[1] = 0;
        // O(m*n)
        for (int i = 2; i <= m; i++) {
            bad[i] = 0;
            for (int j = 1; j < i; j++) {
                // This line is the key point. Originally, I didn't know how to count bad permutations.
                // 因為任何good wall與其他組合組起來，都是bad wall
                // 所以 bad permutation is for j in range(1, i): good[j] * all_permutations[i-j]
                bad[i] += good[j] * total[i - j];
                bad[i] %= modulo;
            }
            // good permutations is (total[i] - bad[i] + modulo)%modulo
            good[i] = (total[i] - bad[i] + modulo) % modulo;
        }

        return (int) good[m];
    }

    public static void main(String[] args) {
        System.out.println(wp(4));
        System.out.println(legoBlocks(5, 5));
    }
}
