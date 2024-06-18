package hackerearth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimGame {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/hackerearth/input.txt"))));
//		int vertices = Integer.parseInt(br.readLine());
//		int players = Integer.parseInt(br.readLine());
//		int sides = Integer.parseInt(br.readLine());
//		int turns = Integer.parseInt(br.readLine());
//		int[][] graph = new int[vertices][vertices];
//		for(int i = 0; i < turns; i++) {
//			String[] splits = br.readLine().split(" ");
//			int w = Integer.parseInt(splits[0]);
//			int x = Integer.parseInt(splits[1]), y = Integer.parseInt(splits[2]);
//			graph[x][y] = w + 1;
//		}
		int[][] graph = solution(3, 5, new String[] { "v 1 2", "x 2 2", "v 1 2", "> 2 1", "x 2 3", "> 2 1", "< 2 0" });
		for (int[] arr : graph) {
			System.out.println(Arrays.toString(arr));
		}
	}

	static int[][] solution(int h, int w, String[] queries) {
		List<int[]> ans = new ArrayList<>();
		int[][] arr = new int[h][w];
		for (String query : queries) {
			String[] splits = query.split(" ");
			String dir = splits[0];
			int x = Integer.parseInt(splits[1]);
			int y = Integer.parseInt(splits[2]);
			if (dir.equals("x")) {
				arr[x][y] = 1;
				continue;
			}
			if (dir.equals("<")) {
				int t = y - 1;
				while (t >= 0 && arr[x][t] == 1) {
					t--;
				}
				if (t < 0) {
					ans.add(new int[] { -1, -1 });
				} else {
					ans.add(new int[] { x, t });
				}
			} else if (dir.equals(">")) {
				int t = y + 1;
				while (t < w && arr[x][t] == 1) {
					t++;
				}
				if (t >= w) {
					ans.add(new int[] { -1, -1 });
				} else {
					ans.add(new int[] { x, t });
				}
			} else if (dir.equals("^")) {
				int t = x - 1;
				while (t >= 0 && arr[t][y] == 1) {
					t--;
				}
				if (t < 0) {
					ans.add(new int[] { -1, -1 });
				} else {
					ans.add(new int[] { t, y });
				}
			} else {
				int t = x + 1;
				while (t < h && arr[t][y] == 1) {
					t++;
				}
				if (t >= h) {
					ans.add(new int[] { -1, -1 });
				} else {
					ans.add(new int[] { t, y });
				}
			}
		}
		return ans.toArray(new int[ans.size()][2]);
	}
}
