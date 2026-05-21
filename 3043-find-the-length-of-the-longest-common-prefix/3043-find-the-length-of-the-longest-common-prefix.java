class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> set=new HashSet<>();
        for(int i : arr1){
            String s=String.valueOf(i);

            for(int k=1;k<=s.length();k++){
                set.add(s.substring(0,k));
            }
        }
        int max=0;

        for(int j : arr2){
            String s=String.valueOf(j);

            for(int i=1;i<=s.length();i++){
                String pre=s.substring(0,i);

                if(set.contains(pre)){
                    max=Math.max(max,pre.length());
                }
            }
        }
        return max;
    }
}