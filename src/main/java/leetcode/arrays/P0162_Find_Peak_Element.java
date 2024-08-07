package leetcode.arrays;

public class P0162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l - (l -r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        var obj = new P0162_Find_Peak_Element();
        System.out.println(obj.findPeakElement(new int[]{1,2,3,1}));
    }
}
