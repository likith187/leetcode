package takeuforward.arrays.easy;

public class P12_Find_Number_That_Appears_Once_Others_Twice {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        var obj = new P12_Find_Number_That_Appears_Once_Others_Twice();
        System.out.println(obj.singleNumber(new int[]{4, -1, 2, -1, 2}));
    }
}
