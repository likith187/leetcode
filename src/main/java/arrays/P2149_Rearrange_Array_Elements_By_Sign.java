package arrays;

public class P2149_Rearrange_Array_Elements_By_Sign {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int p = 0, n = 1;
        for(int num: nums) {
            if (num > 0) {
                ans[p] = num;
                p+=2;
            } else {
                ans[n] = num;
                n+=2;
            }
        }
        return ans;
    }
}
