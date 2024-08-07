package leetcode.arrays;

public class P0079_Word_Search {
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && solve(board, word.toCharArray(), i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean solve(char[][] board, char[] arr, int x, int y, int i) {
		int m = board.length, n = board[0].length;
		if (i >= arr.length) {
			return true;
		}
		if (x >= m || x < 0 || y >= n || y < 0) {
			return false;
		}
		if (board[x][y] == arr[i] && board[x][y] != '\0') {
			char t = board[x][y];
			try {
				board[x][y] = '\0';
				return solve(board, arr, x + 1, y, i + 1) || solve(board, arr, x, y + 1, i + 1) || solve(board, arr, x - 1, y, i + 1) ||solve(board, arr, x, y - 1, i + 1);	
			} finally {
				board[x][y] = t;
			}
			
		}
		return false;
	}

	public static void main(String[] args) {
		var obj = new P0079_Word_Search();
		char[][] chars = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(obj.exist(chars, "ABCB"));
	}
}
