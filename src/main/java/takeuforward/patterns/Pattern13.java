package takeuforward.patterns;

public class Pattern13 {
    public static void main(String[] args) {
        pattern(15);
    }

    private static void pattern(int n) {
        int counter = 1;
        for (int i = 1; counter != n; i++) {
            for (int j = 0; j < i; j++) {
                if (counter == n) break;
                System.out.print(counter++ + " ");
            }
            System.out.println();
        }
    }
}
