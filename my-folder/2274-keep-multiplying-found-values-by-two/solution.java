class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean x=true;
        while(x){
            x=search(nums,original);
            original*=2;
        }
        return original/2;
    }
    boolean search(int[] nums,int original){
        for(int i : nums){
            if(i==original){
                return true;
            }
        }
        return false;
    }
}
