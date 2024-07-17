package arrays;

public class P0136_Single_Number {
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}
	public static void main(String[] args) {
		var obj = new P0136_Single_Number();
		System.out.println(obj.singleNumber(new int[] {4,-1,2,-1,2}));
	}
}
