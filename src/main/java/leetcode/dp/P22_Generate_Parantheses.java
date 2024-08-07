package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class P22_Generate_Parantheses {
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        list.add("()");
        for(int i = 1; i < n; i++) {
            List<String> temp = new ArrayList<>();
            for(String str:list) {
                for(int k = str.lastIndexOf('('); k < str.length()-1; k++) {
                    temp.add(str.substring(0, k + 1) + "()" + str.substring(k+1));
                }
                temp.add(str + "()");
            }
            list = temp;
        }
        return list;
    }
}
