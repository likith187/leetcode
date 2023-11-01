package dp;

import java.util.ArrayList;
import java.util.List;

public class P118_PascalsTriangel {

	public static void main(String[] args) {
		P118_PascalsTriangel obj = new P118_PascalsTriangel();
		System.out.println(obj.generate(4));
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ans = new ArrayList<>();
		ans.add(List.of(1));
		List<Integer> temp = new ArrayList<>();
		List<Integer> prev = ans.get(0);
		for (int i = 1; i < numRows; i++) {
			temp = new ArrayList<>();
			temp.add(1);
			for (int j = 1; j < prev.size(); j++) {
				temp.add(prev.get(j - 1) + prev.get(j));
			}
			temp.add(1);
			ans.add(temp);
			prev = temp;
		}
		return ans;
	}
}
