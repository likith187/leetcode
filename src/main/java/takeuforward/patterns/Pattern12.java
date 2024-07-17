package takeuforward.patterns;

public class Pattern12 {
    public static void main(String[] args) {
        pattern(5);
    }

    private static void pattern(int n) {
        int width = n * 2 - 2;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = 0; j < width; j++) {
                System.out.print(" ");
            }
            for(int j = i; j > 0; j--) {
                System.out.print(j);
            }
            width-=2;
            System.out.println();
        }
    }
}
