package arrays;

public class P0134_Gas_Station {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int current = 0;
        int start = 0;
        for(int i = 0; i < n + n; i++) {
            current += gas[i % n];
            current -= cost[i % n];
            if (current < 0) {
                start = i + 1;
                current = 0;
            } else if (i - start >= n) {
                return start;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		var obj = new P0134_Gas_Station();
		System.out.println(obj.canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
	}
}
