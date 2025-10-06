class Solution {
    public boolean isPalindrome(int x) {
        int rev=0;
        if(x<0){
            return false;
        }
        int n=x;
        while(x>0){
            int digit=x%10;
            rev= rev*10 + digit;
            x=x/10;
        }
        return rev==n;
    }
}
