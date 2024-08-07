package leetcode.string;

import java.util.Arrays;

public class P0043_Multiply_Strings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int n = num1.length(),  m = num2.length();
        int[] product = new int[n + m];
        for(int j = 0; j < m; j++ ) {
            int r = num2.charAt(m - j - 1) - '0';
            int carry = 0;
            int k = product.length - j - 1;
            for (int i = 0; i < n; i++) {
                int temp = (num1.charAt(n - i - 1) - '0') * r + carry + product[k];
                if (temp > 9) {
                    product[k--] = temp % 10;
                    carry = temp / 10;
                } else {
                    product[k--] = temp;
                    carry = 0;
                }
            }
            if (carry > 0) {
                product[k--] = carry;
            }
        }
        int i = 0;
        for(i = 0; i < product.length && product[i] == 0; i++);
        return Arrays.stream(Arrays.copyOfRange(product, i, product.length)).boxed().map(e -> String.valueOf(e)).reduce((a,b) -> a+b).get();
    }

    public static void main(String[] args) {
        var obj = new P0043_Multiply_Strings();
        System.out.println(obj.multiply("123", "456"));
    }
}
