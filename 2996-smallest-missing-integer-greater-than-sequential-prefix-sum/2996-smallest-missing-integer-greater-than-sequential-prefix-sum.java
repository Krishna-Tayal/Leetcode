class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        int index=0;
        for(int i=1;i<n;i++){
            if(nums[i] == nums[i-1]+1){
                index=i;
            }
            else{
                break;
            }
        }
        int sum=0;
        for(int i=0;i<=index;i++){
            sum+=nums[i];
        }
        Arrays.sort(nums);
        for(int i : nums){
            if(sum==i){
                sum++;
            }
        }
        return sum;
    }
}