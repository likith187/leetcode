package leetcode.arrays;

public class P1283_Find_The_Smallest_Divisor_Given_A_Threshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        while (min < max) {
            int mid = (min + max) >> 1;
            if (good(nums, mid, threshold)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean good(int[] nums, int target, int threshold) {
        int count = 0;
        for(int num: nums) {
            count += (num + target - 1) / target;
        }
        return count <= threshold;
    }

    public static void main(String[] args) {
        var obj = new P1283_Find_The_Smallest_Divisor_Given_A_Threshold();
        System.out.println(obj.smallestDivisor(new int[]{44,22,33,11,1}, 5));
    }
}
