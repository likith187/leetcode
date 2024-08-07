package leetcode.arrays;

import java.util.Arrays;

public class P0059_Spiral_Matrix2 {

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int[][] rot = {{0,1},{1,0},{0,-1},{-1,0}};
        int d = 0;
        int len = n - 1;
        int x = 0, y = 0;
        int i = 0;
        arr[0][0] = 1;
        while(i < n * n && len > 0) {
        	int t = len;
        	while (t > 0) {
                arr[x][y] = i + 1;
            	x = x + rot[d][0];
            	y = y + rot[d][1];
                t--;
                i++;
        	}
            d++;
        	d = d %4;
        	if (d == 0) {
        		len -= 2;
        		x++;
            	y++;
        	}
        }
        if (len == 0) {
    		arr[x][y] = i + 1;
    	}
        return arr;
    }
    
    public static void main(String[] args) {
		int[][] arr = new P0059_Spiral_Matrix2().generateMatrix(3);
		for(int[]a:arr) {
			System.out.println(Arrays.toString(a));
		}
	}
}
