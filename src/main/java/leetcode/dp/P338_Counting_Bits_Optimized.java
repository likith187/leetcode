package leetcode.dp;

import java.util.Arrays;

public class P338_Counting_Bits_Optimized {
	
	public int[] countBits(int n) {
        if (n == 0) {
        	return new int[] {0};
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = 1 + arr[i & i - 1];
        }
        return arr;
    }
	
	public static void main(String[] args) {
		var obj = new P338_Counting_Bits_Optimized();
		System.out.println(Arrays.toString(obj.countBits(5)));
	}
}
