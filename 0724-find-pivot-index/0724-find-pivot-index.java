class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int[] prefix_sum=new int[n];
        prefix_sum[0]=nums[0];

        for(int i=1;i<n;i++){
            prefix_sum[i]=prefix_sum[i-1]+nums[i];
        }
        int leftsum=0;int rightsum=prefix_sum[n-1]-prefix_sum[0];
        if(leftsum==rightsum) return 0;
        for(int i=1;i<n;i++){
            leftsum=prefix_sum[i-1];
            rightsum=prefix_sum[n-1]-prefix_sum[i];
            if(leftsum==rightsum) return i;
        }
        return -1;
    }
}