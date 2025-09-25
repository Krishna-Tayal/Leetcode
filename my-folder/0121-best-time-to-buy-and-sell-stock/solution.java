class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int min_pur=prices[0];
        int profit=0;

        for(int i=1;i<n;i++){
            if(min_pur>prices[i]){
                min_pur=prices[i];
            }

            profit= Math.max(profit, prices[i]-min_pur);
        }
        return profit;
    }
}
