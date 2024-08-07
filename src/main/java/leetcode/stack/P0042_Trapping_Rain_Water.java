package leetcode.stack;

import java.util.stream.IntStream;

//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

//
//
//
//Example 1:
//
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6O
//Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
//
//Example 2:
//
//Input: height = [4,2,0,3,2,5]
//Output: 9
//
// 
//
//Constraints:
//
//    n == height.length
//    1 <= n <= 2 * 104
//    0 <= height[i] <= 105
//

public class P0042_Trapping_Rain_Water {

	public int trap(int[] height) {
		int maxIndex = IntStream.range(0, height.length)
                .reduce((i, j) -> height[i] >= height[j] ? i : j)
                .orElse(-1);
		int currMax = 0, ans = 0;
		for (int i = 0; i <= maxIndex; i++) {
			if (height[i] > currMax) {
				currMax = height[i];
			} else {
				ans += currMax - height[i];
			}
		}
		currMax = 0;
		for (int j = height.length - 1; j >= maxIndex; j--) {
			if (height[j] > currMax) {
				currMax = height[j];
			} else {
				ans += currMax - height[j];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		var obj = new P0042_Trapping_Rain_Water();
		System.out.println( obj.trap( new int[] {0,1,0,2,1,0,1,3,2,1,2,1} ) );
	}
}

//4ms faster
//class Solution {
//    public int trap(int[] height) {
//		int maxIndex = 0; // Assume the first element is the maximum initially
//
//        for (int i = 1; i < height.length; i++) {
//            if (height[i] > height[maxIndex]) {
//                maxIndex = i; // Update maxIndex if a larger element is found
//            }
//        }
//		int currMax = 0, ans = 0;
//		for (int i = 0; i <= maxIndex; i++) {
//			if (height[i] > currMax) {
//				currMax = height[i];
//			} else {
//				ans += currMax - height[i];
//			}
//		}
//		currMax = 0;
//		for (int j = height.length - 1; j >= maxIndex; j--) {
//			if (height[j] > currMax) {
//				currMax = height[j];
//			} else {
//				ans += currMax - height[j];
//			}
//		}
//		return ans;
//	}
//}
