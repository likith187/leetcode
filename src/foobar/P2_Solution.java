package foobar;

public class P2_Solution {
	public static String solution(long x, long y) {
        x = x + --y;
        long ans = (x * (x + 1))/2 - y;
        return String.valueOf(ans);
    }
	
	public static void main(String[] args) {
		System.out.println(solution(3, 2));
	}
}
