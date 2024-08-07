package leetcode.arrays;

import java.util.TreeMap;

public class P2592_Maximize_Greatness {
	public int maximizeGreatness(int[] nums) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(int num: nums) {
        	mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for(int num: nums) {
        	Integer high = mp.higherKey(num);
        	if (high != null) {
        		int count = mp.get(high) - 1;
        		if (count > 0) {
            		mp.put(high, count);
        		} else {
        			mp.remove(high);
        		}
        		res++;
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		var obj = new P2592_Maximize_Greatness();
		System.out.println(obj.maximizeGreatness(new int[] {1,3,5,2,1,3,1}));
	}
}
