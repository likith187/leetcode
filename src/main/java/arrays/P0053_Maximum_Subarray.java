package arrays;

public class P0053_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int res = nums[0], local = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(local + nums[i], nums[i]);
            res = Math.max(res, local);
        }
        return res;
    }

    public static void main(String[] args) {
        var obj = new P0053_Maximum_Subarray();
        System.out.println(obj.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
