package takeuforward.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class P14_Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum - k;
            count += map.getOrDefault(rem, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1 );
        }
        return count;
    }

    public static void main(String[] args) {
        var obj = new P14_Subarray_Sum_Equals_K();
        System.out.println(obj.subarraySum(new int[]{1, 1, 1}, 2));
    }
}
