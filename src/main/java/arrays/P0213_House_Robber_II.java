package arrays;

import java.util.Arrays;

public class P0213_House_Robber_II {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        int[] cache2 = new int[nums.length];
        Arrays.fill(cache2, -1);
        return Math.max(calculate(nums, cache, 0, 1), calculate(nums, cache2, 1, 0));
    }

    private int calculate(int[] nums, int[] cache, int i, int offset) {
        if ( i >= nums.length - offset) return 0;
        if (cache[i] != -1) return cache[i];
        cache[i] = Math.max(nums[i] + calculate(nums, cache, i + 2, offset), calculate(nums, cache, i + 1, offset));
        return cache[i];
    }

    public static void main(String[] args) {
        var obj = new P0213_House_Robber_II();
        System.out.println(obj.rob(new int[]{1,2,3,1}));
    }
}
