package takeuforward.strings.easy;

public class P04_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        char[] arr = strs[0].toCharArray();
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (String s: strs) {
                if (i >= s.length() || s.charAt(i) != arr[i]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
