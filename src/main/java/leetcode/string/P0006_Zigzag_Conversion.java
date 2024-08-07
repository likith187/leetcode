package leetcode.string;

public class P0006_Zigzag_Conversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int[] gap = {(numRows - 1) * 2, 0};
        for (int row = 0; row < numRows; row++) {
            int i = row, c = 0;
            while (i < s.length()) {
                sb.append(s.charAt(i));
                if (row == numRows - 1) {
                    i += gap[1];
                } else if (row == 0 || c++ % 2 == 0) {
                    i += gap[0];
                } else {
                    i += gap[1];
                }
            }
            gap[0] = gap[0] - 2;
            gap[1] = gap[1] + 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var obj = new P0006_Zigzag_Conversion();
        System.out.println(obj.convert("PAYPALISHIRING", 4));
    }
}
