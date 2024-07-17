package arrays;

import java.util.Arrays;

public class P0179_Largest_Number {
    public String largestNumber(int[] nums) {
        return Arrays.stream(nums).boxed().map(String::valueOf).sorted((a, b) -> (a + b).compareTo(b + a)).reduce((a, b) -> b + a).get();
    }

    public static void main(String[] args) {
        var obj = new P0179_Largest_Number();
        System.out.println(obj.largestNumber(new int[] {3,30,34,5,9}));
    }
}
