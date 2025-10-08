class Solution {
    public void sortColors(int[] nums) {
        int red=0, white=0, blue=0;
        for(int i : nums){
            if(i==0){
                red++;
            }
            else if(i==1){
                white++;
            }
            else{
                blue++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i<red){
                nums[i]=0;
            }
            else if(i < white+red){
                nums[i]=1;
            }
            else{
                nums[i]=2;
            }
        }
    }
}
