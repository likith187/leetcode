package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0054_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int[][] rot = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int x = 0, y = 0;
        int i = 0;
        int total = n * m;
        n--;
        m--;
//        arr[0] = 1;
        while (i < total && m > 0 && n > 0) {
            int t = d % 2 == 0 ? n : m;
            while (t > 0) {
                list.add(matrix[x][y]);
                x = x + rot[d][0];
                y = y + rot[d][1];
                t--;
                i++;
            }
            d++;
            d = d % 4;
            if (d == 0) {
                m -= 2;
                n -= 2;
                x++;
                y++;
            }
        }
        while (m > 0 && n == 0) {
            list.add(matrix[x][y]);
            x++;
            m--;
        }
        while (n > 0 && m == 0) {
            list.add(matrix[x][y]);
            y++;
            n--;
        }
        return list;
    }

    public static void main(String[] args) {
        var arr = new int[][]{{1, 2, 2, 2, 3}, {4, 5, 5, 5, 6}};
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println(new P0054_Spiral_Matrix().spiralOrder(arr));
    }
}
