import java.util.*;
class Solution {
    public String reverseWords(String s) {
        StringTokenizer st= new StringTokenizer(s);
        int n= st.countTokens();
        String string="";

        for(int i=0;i<n;i++){
            String word=st.nextToken();
            string= word+" "+string;
        }
        return string.substring(0,string.length()-1);
    }
}
