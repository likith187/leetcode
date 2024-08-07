package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sample {
    public static void main(String[] args) throws InterruptedException {
        List<D> set = new ArrayList<D>();
        set.add(new D(1));
        set.add(new D(2));
        set.add(new D(13));
        set.add(new D(4));
        Collections.sort(set);
        for (D i : set) {
            System.out.println(i.age);
        }
    }
    public static class D implements Comparable<D> {
        public final int age;

        public D(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(D o) {
            return age - o.age;
        }
    }
}
