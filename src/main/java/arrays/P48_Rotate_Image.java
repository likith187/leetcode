package arrays;

public class P48_Rotate_Image {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			int m = n % 2 == 0 ? n / 2 : (n + 1) / 2;
			for (int j = 0; j < m; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = temp;
			}
		}
	}
}
