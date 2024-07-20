package takeuforward.strings.easy;

public class P05_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        return score(s).equals(score(t));
    }

    private static String score(String s) {
        int[] arr = new int[256];
        int i = 1;
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            if (arr[c] == 0) {
                arr[c] = i++;
            }
            sb.append(arr[c]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var obj = new P05_Isomorphic_Strings();
        System.out.println(obj.isIsomorphic("paper", "title"));
    }
}
