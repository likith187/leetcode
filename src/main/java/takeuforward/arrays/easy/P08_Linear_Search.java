package takeuforward.arrays.easy;

public class P08_Linear_Search {
    public static void main(String[] args) {
        var obj = new P08_Linear_Search();
        var arr = new int[]{0, 1, 0, 3, 12};
        var ans = obj.search(arr, 12);
        System.out.println(ans);
        ans = obj.search(arr, 15);
        System.out.println(ans);
    }

    private int search(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
}
