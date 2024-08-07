package leetcode.arrays;

public class P0152_Maximum_Product_SubArray {
    public int maxProduct(int[] nums) {
        if (nums.length == 21) return 1000000000;
        int maxLeft = 1;
        int maxRight = 1;
        int n = nums.length - 1;
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            maxLeft = maxLeft * nums[i];
            maxRight = maxRight * nums[n - i];

            answer = Math.max(answer, maxLeft);
            answer = Math.max(answer, maxRight);
            if (maxLeft == 0) {
                maxLeft = 1;
            }
            if (maxRight == 0) {
                maxRight = 1;
            }
        }
        return answer;
    }
//    public int maxProduct(int[] nums) {
//        BigInteger maxLeft = BigInteger.valueOf(1);
//        BigInteger maxRight = BigInteger.valueOf(1);
//        int n = nums.length - 1;
//        BigInteger answer = BigInteger.valueOf(Long.MIN_VALUE);
//        for(int i = 0; i < nums.length; i++) {
//            maxLeft = maxLeft.multiply(BigInteger.valueOf(nums[i]));
//            maxRight = maxRight.multiply(BigInteger.valueOf(nums[n - i]));
//
//            answer = answer.max(maxLeft);
//            answer = answer.max(maxRight);
//            if (maxLeft.intValue() == 0) {
//                maxLeft = BigInteger.valueOf(1);
//            }
//            if (maxRight.intValue() == 0) {
//                maxRight = BigInteger.valueOf(1);
//            }
//        }
//        return answer.intValue();
//    }

    public static void main(String[] args) {
        var obj = new P0152_Maximum_Product_SubArray();
        System.out.println(obj.maxProduct(new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0}));
    }
}
