package arrays;

import java.util.Arrays;

public class P34_First_And_Last_Position {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int[] result = {-1,-1};
        while (l <= r) {
        	int mid = (l + r) / 2;
        	if (target == nums[mid]) {
        		result[0] = mid;
        		r = mid - 1;
        	}
        	else if (target < nums[mid]) {
        		r = mid - 1;
        	} else {
        		l = mid + 1;
        	}
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
        	int mid = (l + r) / 2;
        	if (target == nums[mid]) {
        		result[1] = mid;
        		l = mid + 1;
        	}
        	else if (nums[mid] < target) {
        		l = mid + 1;
        	} else {
        		r = mid - 1;
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
		var obj = new P34_First_And_Last_Position();
		System.out.println(Arrays.toString(obj.searchRange(new int[]{1,8,8,8,8,8,8,8,8,8,10,10}, 1)));
	}
}
