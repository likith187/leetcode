package arrays;

public class P209_Minimize_Size_Subarray_Sum {
	public int minSubArrayLen(int target, int[] nums) {
		int ans = 0;
		int res = Integer.MAX_VALUE, left = 0;
		for (int i = 0; i < nums.length; i++) {
			ans += nums[i];
			while (ans >= target) {
				res = Math.min(res, i + 1 - left);
				ans -= nums[left];
				left++;
			}
		}
		return res == Integer.MAX_VALUE ? 0: res;
	}
	
	public static void main(String[] args) {
		var obj = new P209_Minimize_Size_Subarray_Sum();
		System.out.println(obj.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
	}
}
