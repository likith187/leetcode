package leetcode.arrays;

import java.util.Arrays;

public class P0198_House_Robber {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return calculate(nums, cache, 0);
    }

    private int calculate(int[] nums, int[] cache, int i) {
        if ( i >= nums.length) return 0;
        if (cache[i] != -1) return cache[i];
        cache[i] = Math.max(nums[i] + calculate(nums, cache, i + 2), calculate(nums, cache, i + 1));
        return cache[i];
    }

    public static void main(String[] args) {
        var obj = new P0198_House_Robber();
        System.out.println(obj.rob(new int[] {2,7,9,3,1}));
    }
}
