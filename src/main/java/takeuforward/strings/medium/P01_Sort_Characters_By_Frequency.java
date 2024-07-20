package takeuforward.strings.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class P01_Sort_Characters_By_Frequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(char c:arr){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> Integer.compare(map.get(b), map.get(a)));
        queue.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(String.valueOf(c).repeat(Math.max(0, map.get(c))));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var obj = new P01_Sort_Characters_By_Frequency();
        System.out.println(obj.frequencySort("firevsice"));
    }

    public static class Node {
        private final Character c;
        private final int count;
        public Node(Character c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return count == node.count && Objects.equals(c, node.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(c, count);
        }
    }
}
