package takeuforward.binarysearch.array1D;

public class P10_Find_Minimum_In_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0] <= nums[n - 1]) {
            return nums[0];
        }
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high + 1) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if (nums[0] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        var obj = new P10_Find_Minimum_In_Rotated_Sorted_Array();
        System.out.println(obj.findMin(new int[]{5,1,2,3,4}));
    }
}
