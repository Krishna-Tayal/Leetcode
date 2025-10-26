class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long[] square=new long[n];
        for(int i=0;i<n;i++){
            square[i]= (long) nums[i] * nums[i];
        }
        Arrays.sort(square);
        long score=0L;
        for(int i=0;i<n/2;i++){
            score+=square[n-1-i]-square[i];
        }
        if(n%2 != 0){
            score+= square[n/2];
        }
        return score;
    }
}
