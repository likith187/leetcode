package leetcode.dp;

import java.util.Arrays;

public class P338_Counting_Bits {
	
	static int highestPowerof2(int x) {
       
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        return x ^ (x >> 1);  
     
    }
	
	public int[] countBits(int n) {
        if (n == 0) {
        	return new int[] {0};
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
        	int pow2 = highestPowerof2(i);
        	if (pow2 != arr[i]) {
            	arr[i] = 1 + arr[i - pow2];
        	} else {
            	arr[i] = 1;
        	}
        }
        return arr;
    }
	
	public static void main(String[] args) {
		var obj = new P338_Counting_Bits();
		System.out.println(Arrays.toString(obj.countBits(5)));
	}
}
