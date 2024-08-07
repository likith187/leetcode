package leetcode.string;

public class P0058_Length_Of_Last_Word {
    public int lengthOfLastWord(String s) {
        s = s.strip();
        int i = s.length() - 1;
        for(; i >= 0 && s.charAt(i) !=' '; i--);
        return s.length() - i - 1;
    }
}
