package leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P0022_Generate_Paranthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        result.add("()");
        for(int j = 0; j < n - 1; j++) {
            List<String> temp = new ArrayList<>();
            for(String string: result) {
//                temp.add("(" + string + ")");
                int i = 0;
                while(string.charAt(i) != ')' ) {
                    i++;
                }
                while (i >= 0) {
                    temp.add(string.substring(0, i) +"()" +string.substring(i));
                    i--;
                }
//                temp.add("()" + string);
            }
            result = temp;
        }
        Set<String> set = new HashSet<>();
        for(String s: result) {
            if (set.contains(s)) {
                System.out.println(s);
            } else {
                set.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var obj = new P0022_Generate_Paranthesis();
        System.out.println(obj.generateParenthesis(4));
    }
}
