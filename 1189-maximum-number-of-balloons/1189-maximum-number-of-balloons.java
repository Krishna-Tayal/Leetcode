class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq=new int[27];

        String s="balloon";

        for(char ch : text.toCharArray()){
            freq[ch-'a']++;
        }
        int instance=0;
        while(freq[s.charAt(0)-'a']>0){
            for(char ch : s.toCharArray()){
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