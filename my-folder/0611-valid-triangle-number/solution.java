class Solution {
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int ans=0;

        for(int k=n-1;k>=2;k--){
            int left=0;
            int right=k-1;
            while(left<right){
                if(nums[left]+nums[right] > nums[k]){
                    ans+=(right-left);
                    right--;
                }
                else{
                    left++;
                }   
            }
        }
        return ans;
    }
}
