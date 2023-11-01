package dp;

public class P264_Ugly_Number2 {
	public int nthUglyNumber(int n) {
		int[] arr = new int[n];
		int ugly = 0;
		int i2 = 0, i3 = 0, i5 = 0;
		int next2 = 2, next3 = 3, next5 = 5;
		arr[0] = 1;
		for(int i = 1; i < n; i++) {
			ugly = Math.min(next2, Math.min(next3, next5));
			arr[i] = ugly;
			if (ugly == next2) {
				next2 = arr[++i2] * 2;
			}
			if (ugly == next3) {
				next3 = arr[++i3] * 3;
			}
			if (ugly == next5) {
				next5 = arr[++i5] * 5;
			}
		}
		return ugly;
	}
	
	public static void main(String[] args) {
		var obj = new P264_Ugly_Number2();
		System.out.println(obj.nthUglyNumber(12));
	}
}
