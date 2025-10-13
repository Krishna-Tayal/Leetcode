class Solution {
    public List<String> removeAnagrams(String[] words) {
        int i;
        int j=0;
        int n=words.length;
        List<String> string=new ArrayList<>();
        string.add(words[0]);
        for(i=1;i<n;i++){
            if(anagram(words,i,j)){
                continue;
            }
            else{
                string.add(words[i]);
                j=i;
            }
        }
        return string;
    }
    public boolean anagram(String[] words,int i, int j){
        String w1=words[j];
        String w2=words[i];
        if(w1.length() != w2.length()){
            return false;
        }
        int[] freq=new int[26];
        for(int k=0;k<w1.length();k++){
            freq[w1.charAt(k) - 'a']++;
        }
        for(int k=0;k<w1.length();k++){
            freq[w2.charAt(k) - 'a']--;
        }
        for(int k=0;k<26;k++){
            if(freq[k]!=0){
                return false;
            }
        }
        return true;
    }
}
