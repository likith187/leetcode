package leetcode.dp;

import java.util.Arrays;

public class P313_Super_Ugly__Number {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int len = primes.length;
        int[] primeindex = new int[len];
        long[] primemultiple = Arrays.stream(primes).asLongStream().toArray();
        long[] ugly = new long[n];
        ugly[0] = 1;
        for(int i = 1; i < n; i++) {
        	long min = Long.MAX_VALUE;
        	for(long multiple: primemultiple) {
            	min = Math.min(min, multiple);
        	}
        	ugly[i] = min;
        	for(int j = 0; j < len; j++) {
        		if (primemultiple[j] == min) {
        			primeindex[j] += 1;
        			primemultiple[j] = ugly[primeindex[j]] * primes[j];
        		}
        	}
        }
        return (int)ugly[n - 1];
    }
	
	public static void main(String[] args) {
		var obj = new P313_Super_Ugly__Number();
//		System.out.println((long)1073741824 * 2);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(obj.nthSuperUglyNumber(5911, new int[] {2,3,5,7}));
	}
}
