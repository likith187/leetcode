package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class P119_PascalsTriangle2 {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        while(rowIndex > 0){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int i = 1; i < arr.size(); i++) {
                temp.add(arr.get(i - 1) + arr.get(i));
            }
            temp.add(1);
            arr = temp;
            rowIndex--;
        }
        return arr;
    }
}
