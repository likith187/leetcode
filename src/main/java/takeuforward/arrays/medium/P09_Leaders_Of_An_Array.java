package takeuforward.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class P09_Leaders_Of_An_Array {
    public static List<Integer> leaders(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int currMax = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= currMax) {
                answer.add(arr[i]);
                currMax = arr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(leaders(new int[]{16, 17, 4, 3, 5, 2}));
    }
}
