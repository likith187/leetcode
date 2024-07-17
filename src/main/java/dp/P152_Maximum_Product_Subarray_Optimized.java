package dp;

public class P152_Maximum_Product_Subarray_Optimized {
	public int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE;
		int prod = 1;
		for (int i = 0; i < nums.length; i++) {
			prod = prod * nums[i];
			max = Math.max(max, prod);
			if (prod == 0) {
				prod = 1;
			}
		}
		prod = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			prod = prod * nums[i];
			max = Math.max(max, prod);
			if (prod == 0) {
				prod = 1;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		var v = new P152_Maximum_Product_Subarray_Optimized();
		System.out.println(v.maxProduct(new int[] {0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0}));
	}
}
