class Solution {
    public long maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;

        long k_pos= 100000L;
        long k_neg= -100000L;

        long min1= nums[0];
        long min2= nums[1];
        long max1= nums[n-1];
        long max2= nums[n-2];
        long max3= nums[n-3];

        long prod1= k_pos * min1 * min2;
        long prod2= k_pos * max1 * max2;
        long prod3= k_neg * min1 * max1;
        long prod4= max1 * max2 * max3;
        long prod5= max1 * min1 * min2;

        long maxProd = Math.max(prod1,prod2);
        maxProd = Math.max(maxProd, prod3);
        maxProd = Math.max(maxProd, prod4);
        maxProd = Math.max(maxProd, prod5);

        return maxProd;
    }
}
