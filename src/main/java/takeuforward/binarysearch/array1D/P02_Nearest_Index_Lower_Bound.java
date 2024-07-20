package takeuforward.binarysearch.array1D;

public class P02_Nearest_Index_Lower_Bound {
    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lowerBound(new int[] {1,2,3,5,6}, 4));
    }
}
