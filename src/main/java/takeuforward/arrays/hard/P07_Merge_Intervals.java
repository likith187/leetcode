package takeuforward.arrays.hard;

import java.util.Arrays;
import java.util.LinkedList;

public class P07_Merge_Intervals {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		LinkedList<int[]> list = new LinkedList<>();
		for(int[] a:intervals) {
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
		var intervals = new P07_Merge_Intervals().merge(new int[][] {{2,6},{1,3},{8,10},{15,18}});
		for(int[] a:intervals) {
			System.out.println(Arrays.toString(a));
		}
	}
}
