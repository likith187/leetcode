package takeuforward.arrays.easy;

public class P03_Check_If_Array_Is_Sorted {
    public static void main(String args[]) {

//        int arr[] =  {8,7,6,5,4,3,2,1};
        int[] arr = {3,2,1};
        System.out.println(check(arr));
    }

    private static boolean check(int[] arr) {
        int counter = 0;
        boolean ascending = arr[0] - arr[1] <= 0;
        System.out.println(ascending);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] - arr[i] <= 0 != ascending)
                counter++;
        }
        System.out.println(counter);
        return counter == 0;
    }
}
