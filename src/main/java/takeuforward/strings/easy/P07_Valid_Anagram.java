package takeuforward.strings.easy;

import java.util.Arrays;

public class P07_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        char[] arr = new char[256];
        for(char c: s.toCharArray()) {
            arr[c]++;
        }
        char[] arr1 = new char[256];
        for(char c: t.toCharArray()) {
            arr1[c]++;
        }
        for(int i = 0; i < 256; i++) {
            if (arr[i] != arr1[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var obj = new P07_Valid_Anagram();
        System.out.println(obj.isAnagram("anagram", "nagaram"));
        int[] a1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        int[] a2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
//comparing references using == operator
//works the same as a1.equals(a2)
        if (Arrays.equals(a1, a2))
            System.out.println("Arrays are equal.");
        else
            System.out.println("Arrays are not equal.");
    }
}
