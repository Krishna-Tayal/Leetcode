class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        s=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int r=s.length()-1;
        for(int i=0;i<r;i++){
            if(s.charAt(i) != s.charAt(r)){
                return false;
            }
            r--;
        }
        return true;
    }
}
