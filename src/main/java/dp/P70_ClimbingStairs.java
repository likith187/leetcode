package dp;

public class P70_ClimbingStairs {

    public int climbStairs(int n) {
        int  l = 0, r = 1;
        for(int i = 0; i < n; i++) {
        	int t = r;
        	r = l + r;
        	l = t;
        }
        return r;
    }
}
