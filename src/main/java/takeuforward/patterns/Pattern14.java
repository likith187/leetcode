package takeuforward.patterns;

public class Pattern14 {
    public static void main(String[] args) {
        pattern(5);
    }

    private static void pattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i, k = 0; k < i; k++, j += n - k) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
