package takeuforward.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class P02_Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0, c2 = 0, n = nums.length;
        int elem1 = Integer.MIN_VALUE, elem2 = Integer.MIN_VALUE;
        for(int num: nums) {
            if (c1 == 0 && elem2 != num) {
                c1 = 1;
                elem1 = num;
            } else if (c2 == 0 && elem1 != num) {
                c2 = 1;
                elem2 = num;
            } else if (elem1 == num) {
                c1++;
            } else if (elem2 == num) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int num: nums) {
            if (num == elem1) c1++;
            if (num == elem2) c2++;
        }
        List<Integer> ans = new ArrayList<>();
        int mini = (int)(n / 3) + 1;
        if (c1 >= mini) ans.add(elem1);
        if (c2 >= mini) ans.add(elem2);
        return ans;
    }
}
