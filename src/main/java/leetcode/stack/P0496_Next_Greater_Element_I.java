package leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P0496_Next_Greater_Element_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int num: nums2) {
            if (stack.isEmpty()) {
                stack.add(num);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        return Arrays.stream(nums1).map(e -> map.get(e)).toArray();
    }

    public static void main(String[] args) {
        var obj = new P0496_Next_Greater_Element_I();
        var ans = obj.nextGreaterElement(new int[] {1,3,4,2},new int[] {1,3,4,2});
        System.out.println(Arrays.toString(ans));
    }
}
