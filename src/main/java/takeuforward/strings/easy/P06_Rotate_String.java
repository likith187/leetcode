package takeuforward.strings.easy;

public class P06_Rotate_String {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) return true;
        String query = s.charAt(s.length() - 1) + "" + s.charAt(0);
        int idx = goal.indexOf(query);
        while (idx != -1) {
            if (s.equals(goal.substring(idx + 1) + goal.substring(0, idx + 1))) {
                return true;
            }
            idx = goal.indexOf(query, idx + 1);
        }
        return false;
    }
    public boolean rotateStringOptimized(String s, String goal) {
        String str = s + s;
        return (s.length()==goal.length() && str.contains(goal));
    }

    public static void main(String[] args) {
        var obj = new P06_Rotate_String();
        System.out.println(obj.rotateString("iqquydyvivwfvtgkfewecqlarygkqdxaejpfftuspeeomwvagnrdkozpztitulzxzuifmljudkjnzoeswjayjihpazilfcbpfhvv", "ydyvivwfvtgkfewecqlarygkqdxaejpfftuspeeomwvagnrdkozpztitulzxzuifmljudkjnzoeswjayjihpazilfcbpfhvviqqu"));
    }
}
