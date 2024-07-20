package takeuforward.arrays.hard;

import java.util.HashMap;
import java.util.Map;

public class P05_Largest_Subarray_With_0_Sum {
    public int largestSubarrayLen(int[] arr) {
        int sum = 0, maxi = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (map.get(sum) != null) {
                    maxi = Math.max(maxi, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return maxi;
    }
}
