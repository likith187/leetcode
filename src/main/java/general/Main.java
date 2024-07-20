package general;

import java.util.Spliterator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Spliterator<Integer> spliterator = IntStream.range(0, 11).spliterator();
        System.out.println(spliterator.characteristics());
        spliterator.trySplit().forEachRemaining(System.out::println);
        System.out.println("shit");
        spliterator.forEachRemaining(System.out::println);
        System.out.println(spliterator.characteristics());
    }
}
