package takeuforward.strings.easy;

public class P01_Remove_Outermost_Paranthesis {
    public String removeOuterParentheses(String s) {
        int i = 0;
        StringBuffer sb = new StringBuffer();
        for(char c: s.toCharArray()) {
            if (c == '(') {
                if (i > 0) {
                    sb.append(c);
                }
                i++;
            } else {
                i--;
                if (i > 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var obj = new P01_Remove_Outermost_Paranthesis();
        System.out.println(obj.removeOuterParentheses("(()())(())"));
    }
}
