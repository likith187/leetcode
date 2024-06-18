package dp;

import java.util.List;

public class P120_Triangle {

	int[][] dp = new int[200][200];
	boolean[][] dpCache = new boolean[200][200];

	public static void main(String[] args) {
		P120_Triangle obj = new P120_Triangle();
		System.out.println(obj.minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		return calculate(0, 0, triangle);
	}

	private int calculate(int i, int row, List<List<Integer>> triangle) {
		if (row >= triangle.size()) {
			return 0;
		}
		if (dpCache[row][i]) {
			return dp[row][i];
		}
		List<Integer> curr = triangle.get(row);
		int min = curr.get(i) + calculate(i, row + 1, triangle);
		if (i + 1 < curr.size()) {
			min = Math.min(min, curr.get(i + 1) + calculate(i + 1, row + 1, triangle));
		}
		dpCache[row][i] = true;
		dp[row][i] = min;
		return min;
	}
}
