package takeuforward.strings.easy;

import java.util.Arrays;

public class P02_Reverse_Words_In_String {
    public String reverseWords(String s) {
        return Arrays.stream(s.strip().split("\s+")).reduce((a, b) -> b + " " +a).get();
    }

    public static void main(String[] args) {
        var obj = new P02_Reverse_Words_In_String();
        System.out.println(obj.reverseWords("the sky is blue"));
    }
}
