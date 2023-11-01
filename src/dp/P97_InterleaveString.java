package dp;

public class P97_InterleaveString {
	
	boolean[][] cache = new boolean[100][100];
	boolean[][] hasCache = new boolean[100][100];
	
	public static void main(String[] args) {
		P97_InterleaveString obj = new P97_InterleaveString();
		System.out.println(obj.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}
	
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length()) {
			return false;
		}
		return calculate(0, 0, s1, s2, s3);
	}

	private boolean calculate(int i, int j, String s1, String s2, String s3) {
		if (i + j == s3.length()) {
			return true;
		}
		if (hasCache[i][j]) {
			return cache[i][j];
		}
		hasCache[i][j] = true;
		boolean res = false;
		if (i < s1.length() && s3.charAt(i + j) == s1.charAt(i)) {
			res |= calculate(i + 1, j, s1, s2, s3);
		}
		if (j < s2.length() && s3.charAt(i + j) == s2.charAt(j)) {
			res |= calculate(i, j + 1, s1, s2, s3);
		}
		cache[i][j] = res;
		return res;
	}
}
