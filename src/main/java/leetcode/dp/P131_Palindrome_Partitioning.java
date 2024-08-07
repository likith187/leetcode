package leetcode.dp;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P131_Palindrome_Partitioning {
	List<List<String>> res = new ArrayList<>();

	public List<List<String>> partition(String s) {
		generate(0, new LinkedList<>(), s);
		return res;
	}

	private void generate(int index, Deque<String> deque, String s) {
		if (index == s.length()) {
			res.add(new ArrayList<>(deque));
			return;
		}
		for (int i = index + 1; i <= s.length(); i++) {
			if (isPalindrome(index, i - 1, s)) {
				deque.add(s.substring(index, i));
				generate(i, deque, s);
				deque.removeLast();
			}
		}
	}

	private boolean isPalindrome(int start, int end, String s) {
		System.out.println(s.substring(start, end + 1));
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		P131_Palindrome_Partitioning obj = new P131_Palindrome_Partitioning();
		obj.partition("aab");
	}
}
