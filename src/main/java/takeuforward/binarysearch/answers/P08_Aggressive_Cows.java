package takeuforward.binarysearch.answers;

import java.util.Arrays;

public class P08_Aggressive_Cows {
    public int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int min = stalls[0] - 1;
        int max = stalls[stalls.length - 1] + 1;
        while (min < max) {
            int mid = (min + max + 1) >> 1;
            if (good(stalls, mid, k)) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }

    private boolean good(int[] stalls, int target, int k) {
        int count = 1;
        int prev = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            int ad = Math.abs(stalls[i] - prev);
            if (ad >= target) {
                count++;
                prev = stalls[i];
            }
        }
        return count >= k;
    }

    public static void main(String[] args) {
        var obj = new P08_Aggressive_Cows();
        System.out.println(obj.solve(6, 5, new int[]{2, 12, 11, 3, 26, 7}));
    }
}
