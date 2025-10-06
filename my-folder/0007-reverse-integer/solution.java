class Solution {
    public int reverse(int x) {
        int rev=0;
        int neg=1;
        if(x<0){
            neg=-1;
            x*=neg;
        }
        while(x>0){
            int digit=x%10;
            if (rev > (Integer.MAX_VALUE - digit) / 10){
                return 0;
            }
            rev= rev*10 + digit;
            x=x/10;
        }
        return rev*neg;
    }
}
