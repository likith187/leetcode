package general;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        var obj = IntStream.of(1,2,3,4,5,6).filter(e -> e%2 == 0).map(e -> e*e).reduce((a, b)->a*b);
        Dictionary dictionary = new Dictionary(List.of("ABC","LAP","MAN","PLA","XYZ"));
//        System.out.println(dictionary.getSequenceNo("LAP"));
//        System.out.println(dictionary.getSequenceNo("LA"));
//        System.out.println(dictionary.getSequenceNo("ZZZ"));
        int count = 0;
        for (int i = 65; i <= 91; i++) {
            if (dictionary.getSequenceNo("" +(char)i) != 0) {
                continue;
            }
            for (int j = 65; j <= 91; j++) {
                if (dictionary.getSequenceNo("" +(char)i + (char)j) != 0) {
                    continue;
                }
                for (int k = 65; k <= 91; k++) {
                    if (dictionary.getSequenceNo("" + (char)i + (char)j + (char)k) > 0) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

class  Dictionary {
    public Dictionary(List<String> list) {
    }

    public Integer getSequenceNo(String query) {
        var list = List.of("ABC","LAP","MAN","PLA","XYZ");
        int i = 1;
        query = query.toUpperCase();
        for(String key: list) {
            if (key.equals(query)) {
                return i;
            }
            if (key.startsWith(query)) {
                return 0;
            }
            i++;
        }
        return -1;
    }
}

