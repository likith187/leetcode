package leetcode.arrays;

public class P0875_Koko_Eating_Bananas {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = (int)Math.pow(10, 9);
        while(min < max) {
            int mid = (min + max) >> 1;
            if(good(piles, mid, h)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
    private boolean good(int[] piles, int target, int h) {
        int count = 0;
        for(int pile: piles) {
            count += (pile + target - 1) / target;
        }
        return count<=h;
    }
}
