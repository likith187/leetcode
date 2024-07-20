package takeuforward.arrays.easy;

public class P11_Count_Maximum_Consecutive_Ones {
    public int count(int[] arr) {
        int max = 0;
        int localMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                localMax = 0;
            } else {
                localMax = Math.max(localMax, localMax + 1);
                max = Math.max(max, localMax);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        var obj = new P11_Count_Maximum_Consecutive_Ones();
        System.out.println(obj.count(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
