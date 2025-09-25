class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        if (n == 2) return prev1;

        for (int i = 2; i < n; i++) {
            int take = prev2 + nums[i];     
            int skip = prev1;              
            int curr = Math.max(skip, take);
            
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
