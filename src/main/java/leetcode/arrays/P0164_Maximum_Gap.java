package leetcode.arrays;

import java.util.Arrays;

public class P0164_Maximum_Gap {
    public int maximumGap(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int maxVal = Arrays.stream(arr).max().getAsInt();
        int minVal = Arrays.stream(arr).min().getAsInt();
        int[] maxBucket = new int[arr.length - 1];
        int[] minBucket = new int[arr.length - 1];
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        double delta = (double) (maxVal - minVal) / (arr.length - 1);
        for (int num : arr) {
            if (num == maxVal || num == minVal) {
                continue;
            }
            int index = (int) ((num - minVal) / delta);
            maxBucket[index] = Math.max(maxBucket[index], num);
            minBucket[index] = Math.min(minBucket[index], num);
        }
        System.out.println(Arrays.toString(maxBucket));
        System.out.println(Arrays.toString(minBucket));
        int prevVal = minVal;
        int maxGap = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (minBucket[i] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, minBucket[i] - prevVal);
            prevVal = maxBucket[i];
        }
        maxGap = Math.max(maxGap, maxVal - prevVal);

        return maxGap;
    }

    public static void main(String[] args) {
        var obj = new P0164_Maximum_Gap();
        System.out.println(obj.maximumGap(new int[]{1,2,3,4,99,100}));
    }
}
