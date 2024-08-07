package leetcode.arrays;

import common.TreeNode;

public class P0108_Convert_Sorted_Array_To_Binary_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l - ( l - r) / 2;
        return new TreeNode(nums[mid] , build(nums, l, mid - 1), build(nums, mid + 1, r));
    }
}
