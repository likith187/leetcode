package dp;

public class P53_MaxSubArray {
	
	public static void main(String[] args) {
		int[] arr = {5,4,-1,7,8};
		P53_MaxSubArray prob = new P53_MaxSubArray();
		System.out.println(prob.maxSubArray(arr));
	}
	
	public int maxSubArray(int[] nums) {
		int ans = nums[0];
		for(int i = 1; i < nums.length; i++) {
			nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
			ans = Math.max(ans, nums[i]);
		}
		return ans;
	}
	
	public int maxSubArrayKadane(int[] nums) {
		int ans = nums[0], local = nums[0];
		for(int i = 1; i < nums.length; i++) {
			local = Math.max(local + nums[i], nums[i]);
			ans = Math.max(ans, local);
		}
		return ans;
	}
}
