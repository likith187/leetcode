package takeuforward.strings.medium;

public class P02_Maximum_Nesting_Depth {
    public int maxDepth(String s) {
        int i = 0;
        int max = 0;
        for(char c: s.toCharArray()) {
            if (c == '(') {
                i++;
                max = Math.max(max, i);
            } else if (c == ')') {
                i--;
            }
        }
        return max;
    }
}
