class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        Arrays.sort(strs);
        // for(int i=1;i<n;i++){
        //     pre=prefix(pre,strs[i]);
        // }
        return prefix(strs[0],strs[n-1]);
    }
    public String prefix(String s1,String s2){
        int n=Math.min(s1.length(),s2.length());
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return s1.substring(0,i);
            }
        }
        return s1.length()<s2.length()?s1:s2;
    }
}