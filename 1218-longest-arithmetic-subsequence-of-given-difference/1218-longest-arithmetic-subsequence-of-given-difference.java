class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map=new HashMap<>();
        int ans=1;
        for(int i : arr){
                int prev=map.getOrDefault(i-difference,0);
                map.put(i,prev+1);
                ans=Math.max(prev+1,ans);
        }
        return ans;
    }
}