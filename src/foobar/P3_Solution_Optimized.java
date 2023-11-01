package foobar;

import java.math.BigInteger;

public class P3_Solution_Optimized {
	public static String solution(int[] nums) {
		if (nums.length == 0) {
			return "0";
		}
		if (nums.length == 1) {
			return String.valueOf(nums[0]);
		}
		BigInteger product = BigInteger.valueOf(1); 
		int min = Integer.MIN_VALUE, negcount = 0;
		boolean zero = true;
		for (int i: nums) {
			if (i != 0 && i <= 1000) {
				if (i < 0)
					min = Math.max(min, i);
				negcount++;
				product = product.multiply(BigInteger.valueOf(i));
				zero = false;
			}
		}
		if (zero|| (negcount == 1 && product.signum() < 0)) {
			return "0";
		}
        return product.signum() < 0 ? String.valueOf(product.divide(BigInteger.valueOf(min))) : String.valueOf(product); 
    }
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {-2, -3, 4, -5}));
		System.out.println(solution(new int[] {-2, 0, 0, 0, 0}));
		System.out.println(solution(new int[] {0, 0, 0, 0, 0}));
		System.out.println(solution(new int[] {0, 0, 0, 0, 1}));
		System.out.println(solution(new int[] {-2, 2, 5, 2, -2, -2}));
		System.out.println(solution(new int[] {696, 254, 707, 730, 252, 144, 18, -678, 921, 681, -665, 421, -501, 204, 742, -609, 672, -72, 339, -555, -736, 230, -450, 375, 941, 50, 897, -192, -912, -915, 609, 100, -933, 458, -893, 932, -590, -209, 107, 473, -311, 73, 68, -229, 480, 41, -235, 558, -615, -289, -643}));
	}
}
