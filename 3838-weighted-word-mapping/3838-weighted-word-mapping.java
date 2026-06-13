class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n=words.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            int w=0;
            for(char ch : words[i].toCharArray()){
                w+= weights[ch - 'a'];
            }
            res[i]= w%26 ;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append((char)(122-res[i]));
        }
        return sb.toString();
    }
}