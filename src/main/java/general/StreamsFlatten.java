package general;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsFlatten {
    public static void main(String[] args) {
        Object[] array = {1, 2, new Object[]{3, 4, new Object[]{5}, 6, 7}, 8, 9, 10};

        Integer[] flattenedArray = flatten(array).map(e -> (Integer)e).toArray(Integer[]::new);
        System.out.println(IntStream.range(0, 11).boxed().skip(4).reduce((a, b) -> a - b < 0 ? a : b));
        System.out.println(Arrays.toString(flattenedArray));
    }

    public static Stream<Object> flatten(Object[] inputArray)  {

        return Arrays.stream(inputArray).flatMap(e -> {
            if (e instanceof Integer) {
                return Stream.of(e);
            } else {
                return flatten((Object[])e);
            }
        });
    }
}