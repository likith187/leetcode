package leetcode.arrays;

public class P0169_Majority_Element {

    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majority = nums[i];
                count = 1;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        var obj = new P0169_Majority_Element();
        var result = obj.majorityElement(new int[]{3,2,3});
        System.out.println(result);
    }
}
