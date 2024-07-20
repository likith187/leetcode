package takeuforward.arrays.easy;

public class P02_Find_Second_Smallest_And_Second_Largest_Element {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 4, 7, 7, 5};
        System.out.println("The Largest element in the array is: " + find2ndSmallest(arr1) + " " + find2ndLargest(arr1));

        int arr2[] = {8, 10, 5, 7, 9};
        System.out.println("The Largest element in the array is: " + find2ndSmallest(arr2) + " " + find2ndLargest(arr2));
    }

    private static int find2ndSmallest(int[] arr) {
        int small = Integer.MAX_VALUE, small2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < small) {
                small2 = small;
                small = arr[i];
            } else if (arr[i] < small2 && arr[i] != small) {
                small2 = arr[i];
            }
        }
        return small2;
    }

    private static int find2ndLargest(int[] arr) {
        int large = Integer.MIN_VALUE, large2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > large) {
                large2 = large;
                large = arr[i];
            } else if (arr[i] > large2 && arr[i] != large) {
                large2 = arr[i];
            }
        }
        return large2;
    }
}
