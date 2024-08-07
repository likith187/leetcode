package leetcode.arrays;

import java.util.Arrays;

public class P1011_Capacity_To_Ship_Packages_Within_D_Days {
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = (int) Math.pow(10, 8);
        while (low < high) {
            int mid = (low + high) >> 1;
            if (good(weights, mid, days)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean good(int[] weights, int target, int days) {
        int total = 0;
        int targetDays = 0;
        for (int weight : weights) {
            total += weight;
            if (total >= target) {
                total = total > target ? weight : 0;
                targetDays++;
            }
        }
        if (total > 0) {
            targetDays++;
        }
        return  targetDays<= days;
    }

    public static void main(String[] args) {
        var obj = new P1011_Capacity_To_Ship_Packages_Within_D_Days();
        System.out.println(obj.shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(obj.shipWithinDays(new int[]{1,2,3,1,1}, 4));
//        System.out.println(obj.good(new int[]{3,2,2,4,1,4}, 5, 3));
    }
}
