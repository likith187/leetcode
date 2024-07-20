package takeuforward.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class P13_Longest_Subarray_With_K_Sum_Positives {
    public static int getLongestSubarray(int[] a, int k) {
        int maxLen = 0, total = 0;
        int n = a.length;
        Map<Integer, Integer> sum = new HashMap<>();
        for (int i = 0; i < n; i++) {
            total += a[i];
            if (total == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int rem = total - k;
            if (sum.containsKey(rem)) {
                maxLen = Math.max(maxLen, i - sum.get(rem) + 1);
            }
            if (!sum.containsKey(total)) {
                sum.put(total, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] a = { -1, 1, 1};
        int k = 1;
        int len = getLongestSubarray(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
}
