package leetcode.arrays;

public class P0287_Find_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        if (nums.length == 2) {
            return nums[0];
        }
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        var obj = new P0287_Find_Duplicate_Number();
        System.out.println(obj.findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
    }
}
