class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;
        int n=coins.length;

        int[] dp=new int[amount+1];
        
        Arrays.fill(dp,amount+1);
        
        dp[0]=0;
        for(int c : coins){
            for(int a=c;a<=amount;a++){
                dp[a] = Math.min(dp[a], 1 + dp[a - c]);
            }
        }
        return dp[amount]>amount?-1:dp[amount] ;
        
    }
}