class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int val = (nums[i] == target) ? 1 : -1;
            prefix[i + 1] = prefix[i] + val;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (prefix[j] - prefix[i] > 0) {
                    ans++;
                }
            }
        }

        return ans;


    // int n=nums.length;
    //     int sub=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             sub+=majority(nums,i,j,target);
    //         }
    //     }
    //     return sub;
    // public int majority(int[] nums, int i,int j,int target){
    //     int len=j-i+1;
    //     int count=0;
    //     for(int k=i;k<=j;k++){
    //         if(nums[k]==target){
    //             count++;
    //         }
    //     }
    //     if(count > len/2){
    //         return 1;
    //     }
    //     return 0;
    }
}