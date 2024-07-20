package takeuforward.binarysearch.array1D;

public class P11_Find_Rotation_Count {
    public int findCount(int[] nums) {
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
        return low + 1;
    }

    public static void main(String[] args) {
        var obj = new P11_Find_Rotation_Count();
        System.out.println(obj.findCount(new int[]{5,1,2,3,4}));
    }
}
