class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int max=0;
        for(int p : piles){
            max=Math.max(max,p);
        }
        int left=1;
        int right=max;
        while(left<right){
            int mid=left+(right-left)/2;
            if(totalhrs(piles,mid,h)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }

    private boolean totalhrs(int[] piles, int m, int hrs){
        long total=0L;
        for(int pile : piles){
            total+= (pile+m -1)/m;
            if(total>hrs){
                return false;
            }
        }
        return total<=hrs;
    }
}
