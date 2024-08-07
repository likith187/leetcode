package leetcode.string;

public class P0003_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int[] arr = new int[256];
        int t = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            t = Math.max(t, arr[c]);
            max = Math.max(max, i - t + 1);
            arr[c] = i + 1;
        }
        return max;
    }

    public static void main(String[] args) {
        var obj = new P0003_Longest_Substring_Without_Repeating_Characters();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
    }
}
