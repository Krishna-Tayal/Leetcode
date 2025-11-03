class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=colors.length();
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<colors.length();i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                int idx= neededTime[i]>neededTime[i-1] ? i-1 : i;
                dp[i]=dp[i-1]+neededTime[idx];
                neededTime[idx]=Math.max(neededTime[i],neededTime[i-1]);
            }
            else{
                dp[i]=dp[i-1];
            }
        }
        return dp[n-1];
    }
}
