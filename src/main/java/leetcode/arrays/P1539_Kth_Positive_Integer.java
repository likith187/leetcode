package leetcode.arrays;

public class P1539_Kth_Positive_Integer {
    public int findKthPositive(int[] arr, int k) {
        int missing = 0;
        int counter = 0;
        for (int num : arr) {
            int pmissing = missing;
            missing += num - counter - 1;
            if (missing >= k) {
                return counter + (k - pmissing);
            }
            counter = num;
        }
        return counter + (k - missing);
    }

    public int findKthPositiveOptimized(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {

            int mid = (low + high) / 2;
            int missing = arr[mid] - mid - 1;
            if (missing < k) low = mid + 1;
            else high = mid - 1;
        }
        return low + k;
    }

    public static void main(String[] args) {
        var obj = new P1539_Kth_Positive_Integer();
        System.out.println(obj.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println(obj.findKthPositiveOptimized(new int[]{2, 3, 4, 7, 11}, 5));
    }
}
