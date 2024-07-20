package takeuforward.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class P01_Pascals_Triangle {
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
