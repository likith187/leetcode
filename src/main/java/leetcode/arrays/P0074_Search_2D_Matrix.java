package leetcode.arrays;

public class P0074_Search_2D_Matrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length;
		int l = 0, r = m - 1;
		while (l <= r) {
			int mid = (l + r) >>> 1;
			if (matrix[mid][n-1] == target) {
				return true;
			} else if (target < matrix[mid][n-1]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		int row = l >= m ? l - 1: l;
		l = 0;
		r = n - 1;
		while (l <= r) {
			int mid = (l + r) >>> 1;
			if (matrix[row][mid] == target) {
				return true;
			} else if (target < matrix[row][mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		var obj = new P0074_Search_2D_Matrix();
		System.out.println(obj.searchMatrix(new int[][] {{1}}, 1));
	}
}
