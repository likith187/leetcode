package arrays;

import java.util.ArrayList;
import java.util.List;

public class P0119_Pascals_Triangle_2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastRow = List.of(1);
        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(lastRow.get(j) + lastRow.get(j - 1));
            }
            temp.add(1);
            lastRow = temp;
        }
        return lastRow;
    }

    public static void main(String[] args) {
        var obj = new P0119_Pascals_Triangle_2();
        System.out.println(obj.getRow(5));
    }
}
