package takeuforward.arrays.easy;

import java.util.Arrays;

public class P09_Find_The_Union {
    public int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] temp = new int[m + n];
        int i = 0;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                temp[i] = nums1[--m];
            } else {
                temp[i] = nums2[--n];
            }
            i++;
        }
        while (m != 0) {
            temp[i++] = nums1[--m];
        }
        while (n != 0) {
            temp[i++] = nums2[--n];
        }
        return temp;
    }

    public static void main(String[] args) {
        var obj = new P09_Find_The_Union();
        var ans = obj.merge(new int[]{1, 2, 3}, new int[]{-1, 99, 100});
        System.out.println(Arrays.toString(ans));
    }
}
