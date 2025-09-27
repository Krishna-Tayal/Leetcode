import java.util.*;
class Solution {
    public int lengthOfLastWord(String s) {
        StringTokenizer st=new StringTokenizer(s);
        int n=st.countTokens();
        String word="";

        for(int i=0;i<n;i++){
            word=st.nextToken();
        }
        return(word.length());
    }
}
