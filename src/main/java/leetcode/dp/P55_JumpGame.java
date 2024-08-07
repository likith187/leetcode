package leetcode.dp;

public class P55_JumpGame {
	public boolean canJump(int[] nums) {
        int best = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            best = Math.max(best-1, nums[i]);
            if (best == 0) {
                return false;
            }
        }
        return true;
    }
	public boolean canJump2(int[] nums) {

		int curr = nums[0], n = nums.length;
		for(int i = 0; i < nums.length; i++) {
			if (i == curr && nums[i] == 0) {
				break;
			}
			curr = Math.max(i + nums[i], curr);
		}
		return curr >= n - 1;
    }
}
