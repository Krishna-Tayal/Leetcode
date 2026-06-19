class Solution {
    public int largestAltitude(int[] gain) {
        int highest=0;
        int ans=0;
        for(int i : gain){
            highest+=i;
            ans=Math.max(ans,highest);
        }
        return ans;
    }
}