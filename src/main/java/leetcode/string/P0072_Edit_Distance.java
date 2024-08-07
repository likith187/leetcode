package leetcode.string;

import java.util.Arrays;

public class P0072_Edit_Distance {

    public int minDistanceOptimized(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] cache = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            cache[i][0] = i;
        }
        for(int i = 0; i <= n; i++) {
            cache[0][i] = i;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cache[i][j] = cache[i - 1][j - 1];
                } else {
                    cache[i][j] = 1 + Math.min(cache[i - 1][j - 1], Math.min(cache[i - 1][j], cache[i][j - 1]));
                }
            }
        }
        return cache[m][n];
    }

    public int minDistance(String word1, String word2) {
        int[][][] cache = new int[word1.length()][word2.length()][word1.length() + word2.length()];
        for(int i = 0; i < word1.length(); i++) {
            for(int j = 0; j < word2.length(); j++) {
                Arrays.fill(cache[i][j], -1);

            }
        }
        return calculate(0, 0, word1, word2, 0, cache);
    }

    private int calculate(int i, int j, String word1, String word2, int distance, int[][][] cache) {
        if (j == word2.length()) {
            return i < word1.length() ? distance + word1.length() - i : distance;
        }
        if (i >= word1.length()) {
            return distance + word2.length() - j;
        }
        if (cache[i][j][distance] != -1) return cache[i][j][distance];
        int min;
        if (word1.charAt(i) == word2.charAt(j)) {
            min = calculate(i + 1, j + 1, word1, word2, distance, cache);
        } else {
            min = Math.min(calculate(i + 1, j, word1, word2, distance + 1, cache),
                    calculate(i , j + 1, word1, word2, distance + 1, cache));
            min = Math.min(min, calculate(i + 1, j + 1, word1, word2, distance + 1, cache));
        }
        cache[i][j][distance] = min;
        return min;
    }

    public static void main(String[] args) {
        var obj = new P0072_Edit_Distance();
        System.out.println(obj.minDistanceOptimized("intention", "execution"));
    }
}
