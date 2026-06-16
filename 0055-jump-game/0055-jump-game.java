class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int max_jump=0;
        for(int i=0;i<nums.length;i++){
            if(i > max_jump){
                return false;
            }
            max_jump=Math.max(max_jump,nums[i]+i);
            if(nums[i]>=n-1) return true;
        }
        return true;
    }
}