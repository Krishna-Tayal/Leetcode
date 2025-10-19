class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(nums[i]);
        }
        int max=nums[n-1];
        boolean[] dp=new boolean[max/k];
        for(int i=0;i<max/k;i++){
            if(list.contains((i+1)*k)){
                dp[i]=true;
            }
        }
        for(int i=0;i<dp.length;i++){
            if(dp[i]==false){
                return (i+1)*k;
            }
        }
        return ((max/k)+1)*k;
    }
}
