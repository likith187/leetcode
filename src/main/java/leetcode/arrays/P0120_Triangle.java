package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class P0120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] cache = new Integer[triangle.size()][triangle.size()];
        return find(triangle, cache, 0, 0);
    }

    private int find(List<List<Integer>> triangle, Integer[][] cache, int idx, int i) {
        if (idx >= triangle.size()) {
            return 0;
        }
        List<Integer> row = triangle.get(idx);
        if (i >= row.size()) {
            return 0;
        }
        if (cache[idx][i] != null) {
            return cache[idx][i];
        }
        int curr = row.get(i);
        cache[idx][i] = Math.min(find(triangle, cache, idx + 1, i) + curr, find(triangle, cache, idx + 1, i + 1) + curr);
        return cache[idx][i];
    }

    public static void main(String[] args) {
        var obj = new P0120_Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 7));
        triangle.add(List.of(4, 1, 8, 3));
        System.out.println(obj.minimumTotal(triangle));
    }
}
