package foobar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1_Solution {
	public static int[] solution(int[] data, int n) {
		if (data.length > 100) {
			throw new IllegalArgumentException("less than 100 minions are required");
		}
		if (n <= 0) {
			return new int[] {};
		}
		Map<Integer, Integer> map = new HashMap<>();
		for(int d:data) {
			map.put(d, map.getOrDefault(d, 0) + 1);
		}
		return Arrays.stream(data).filter(e -> map.get(e) <= n).toArray();
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		System.out.println(Arrays.toString(solution(arr, 0)));
	}
}
