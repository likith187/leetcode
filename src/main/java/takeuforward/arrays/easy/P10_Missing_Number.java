package takeuforward.arrays.easy;

public class P10_Missing_Number {
    public int missingNumber(int[] nums) {
        int[] temp = new int[nums.length + 1];
        for (int num : nums) {
            temp[num]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) return i;
        }
        return 0;
    }

    public int missingNumberOptimal(int[] nums) {
        int xor = 0;
        for(int i = 1; i <= nums.length; i++) {
            xor ^= i;
        }
        for (int num: nums) {
            xor ^= num;
        }
        return xor;
    }

    public static void main(String[] args) {
        var obj = new P10_Missing_Number();
        System.out.println(obj.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(obj.missingNumberOptimal(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
