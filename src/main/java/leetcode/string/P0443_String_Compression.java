package leetcode.string;

import java.util.Arrays;

public class P0443_String_Compression {
    public int compress(char[] chars) {
        int idx = 0;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                chars[idx++] = chars[i - 1];
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[idx++] = c;
                    }
                }
                count = 1;
            } else {
                count++;
            }
        }
        chars[idx++] = chars[chars.length - 1];
        if (count > 1) {
            for (char c : String.valueOf(count).toCharArray()) {
                chars[idx++] = c;
            }
        }
        return idx;
    }
    public static void main(String[] args) {
        var obj = new P0443_String_Compression();
        char[] arr = "aaaaba".toCharArray();
        System.out.println(obj.compress(arr));
        System.out.println(Arrays.toString(arr));
    }
}
