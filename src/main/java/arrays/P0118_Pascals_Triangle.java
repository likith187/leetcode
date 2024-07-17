package arrays;

import java.util.ArrayList;
import java.util.List;

public class P0118_Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answers = new ArrayList<>();
        List<Integer> lastRow = List.of(1);
        answers.add(lastRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(lastRow.get(j) + lastRow.get(j - 1));
            }
            temp.add(1);
            lastRow = temp;
            answers.add(temp);
        }
        return answers;
    }
}

//class Solution {
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> ans = new ArrayList<>();
//        for (int row = 1; row <= numRows; row++) {
//            ans.add(generaterow(row));
//        }
//        return ans;
//    }
//
//    public List<Integer> generaterow(int row) {
//        long ans = 1;
//        List<Integer> ansrow = new ArrayList<>();
//        ansrow.add(1);
//        for (int col = 1; col < row; col++) {
//            ans *= (row - col);
//            ans /= col;
//            ansrow.add((int) ans);
//        }
//        return ansrow;
//    }
//}