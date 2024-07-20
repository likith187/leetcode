package takeuforward.arrays.hard;

public class P08_Merge_Sorted_Array {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        while(m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[--m];
            } else {
                nums1[i] = nums2[--n];
            }
            i--;
        }
        while(m != 0) {
            nums1[i--] = nums1[--m];
        }
        while(n != 0) {
            nums1[i--] = nums2[--n];
        }
    }
	
	public static void main(String[] args) {
		
	}
}
