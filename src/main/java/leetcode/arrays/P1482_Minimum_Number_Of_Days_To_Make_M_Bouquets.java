package leetcode.arrays;

public class P1482_Minimum_Number_Of_Days_To_Make_M_Bouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int min = 1;
        int max = (int)Math.pow(10, 9)+1;
        // int max = 20;
        boolean solved = false;
        while(min < max) {
            int mid = (min + max) >> 1;
            int res = good(bloomDay, mid, m, k);
            if (res >= m) {
                solved = true;
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return solved ? min : -1;
    }

    private int good(int[] bloomDay, int target, int m, int k) {
        int bouquets = 0;
        int counter = 0;
        for(int bloom: bloomDay) {
            if(bloom <= target) {
                counter++;
            } else {
                bouquets += counter / k;
                counter = 0;
            }
        }
        if (counter > 0) {
            bouquets += counter / k;
        }
        return bouquets ;
    }
}
