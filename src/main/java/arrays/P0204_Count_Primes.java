package arrays;

import java.util.Arrays;

public class P0204_Count_Primes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        int count = 0;
        for(int i = 2; i < n; i++) {
            if (prime[i]) {
                count++;
                for(int j = i * 2; j < n; j+=i) {
                    prime[j] = false;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var obj = new P0204_Count_Primes();
        System.out.println(obj.countPrimes(10));
    }
}
