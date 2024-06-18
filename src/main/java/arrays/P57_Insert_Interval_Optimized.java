package arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class P57_Insert_Interval_Optimized {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		LinkedList<int[]> list = new LinkedList<>();
		for(int[] a:intervals) {
			if (a[1] < newInterval[0]) {
				list.add(a);
			} else if (newInterval[1] < a[0]){
				list.add(newInterval);
				newInterval = a;
			} else {
				newInterval[0] = Math.min(newInterval[0], a[0]);
				newInterval[1] = Math.max(newInterval[1], a[1]);
			}
		}
		list.add(newInterval);
		return list.toArray(new int[list.size()][2]);
	}
	public static void main(String[] args) {
		var intervals = new P57_Insert_Interval_Optimized().insert(new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[] {4, 8});
		for(int[] a:intervals) {
			System.out.println(Arrays.toString(a));
		}
	}
}
