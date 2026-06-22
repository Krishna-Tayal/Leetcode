class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] freq=new int[27];

        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        int instance=0;
        while(freq[target.charAt(0)-'a']>0){
            for(char ch : target.toCharArray()){
                if(freq[ch-'a']<=0){
                    return instance;
                }
                freq[ch-'a']--;
            }
            instance++;
        }
        return instance;
    }
}