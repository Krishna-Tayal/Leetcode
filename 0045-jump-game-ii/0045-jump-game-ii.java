class Solution {
    public int jump(int[] nums) {
        int max_jump=0;
        int jumps=0;
        int current_jump=0;

        for(int i=0;i<nums.length-1;i++){
            max_jump=Math.max(max_jump,i+nums[i]);

            if(i==current_jump){
                jumps++;
                current_jump=max_jump;
            }
        }
        return jumps;
    }
}