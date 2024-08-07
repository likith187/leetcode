package leetcode.arrays;

public class P0073_Set_Matrix_Zeros {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int[] rows = new int[m];
		int[] columns = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					columns[j] = 1;
				}
			}
		}
		for (int r = 0; r < rows.length; r++) {
			if (rows[r] == 0) continue;
			for (int i = 0; i < n; i++) {
				matrix[r][i] = 0;
			}
		}
		for (int c = 0; c < columns.length; c++) {
			if (columns[c] == 0) continue;
			for (int i = 0; i < m; i++) {
				matrix[i][c] = 0;
			}
		}
	}

	public static void main(String[] args) {
		var obj = new P0073_Set_Matrix_Zeros();

	}
}
