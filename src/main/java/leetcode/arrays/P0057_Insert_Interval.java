package leetcode.arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class P0057_Insert_Interval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		LinkedList<int[]> old = new LinkedList<>();
		boolean added = false;
		for(int[] a: intervals) {
			if (!added && a[0] >= newInterval[0]) {
				old.add(newInterval);
				added = true;
			}
			old.add(a);
		}
		if (!added) {
			old.add(newInterval);
		}
//		old.forEach(e -> System.out.println(Arrays.toString(e)));
		LinkedList<int[]> list = new LinkedList<>();
		for(int[] a:old) {
			if (list.isEmpty()) {
				list.add(a);
			} else {
				if (list.getLast()[1] >= a[0]) {
					list.getLast()[1] = Math.max(list.getLast()[1], a[1]);
				} else {
					list.add(a);
				}
			}
		}
		return list.toArray(new int[list.size()][2]);
	}
	public static void main(String[] args) {
		var intervals = new P0057_Insert_Interval().insert(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[] {4, 8});
		for(int[] a:intervals) {
			System.out.println(Arrays.toString(a));
		}
	}
}
