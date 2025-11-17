class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int left=0;int right=nums.length-1;;
        while(left<right){
            if(nums[left]==1 && nums[right]==1){
                if(right-left-1 < k){
                    return false;
                }
                left++;
            }
            else if(nums[left]==1 && nums[right]!=1){
                right--;
            }
            else{
                left++;
            }
        }
        return true;
    }
}
