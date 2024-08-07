package leetcode.dp;

public class P63_UniquePath_2 {
	public int uniquePathsWithObstacles(int[][] ogrid) {
        int m = ogrid.length, n = ogrid[0].length;
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++) {
            if (ogrid[i][0] == 1) {
                break;
            }
            grid[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            if (ogrid[0][i] == 1) {
                break;
            }
            grid[0][i] = 1;
        }
        for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if (ogrid[i][j] != 1) {
					grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
				}
			}
		}
        return grid[m - 1][n - 1];
    }
}
