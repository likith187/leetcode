package OneBrc;

import java.io.*;

public class Solution {
    private static final String FILE = "/home/likith/workspace/projects/1brc/measurements.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE)));
        long start = System.currentTimeMillis();
        String i;
        while ((i = reader.readLine()) != null) {
//            System.out.println(i);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
