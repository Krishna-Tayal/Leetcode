class Solution {
    public int longestSubsequence(int[] nums) {
        int totalxor=0;
        boolean iszero=true;
        for(int i : nums){
            totalxor^=i;
        }
        if(totalxor!=0){
            return nums.length;
        }
        for(int i : nums){
            if(i!=0){
                iszero=false;
                break;
            }
        }
        if(iszero){
            return 0;
        }
        return nums.length-1;
    }
}
