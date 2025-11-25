class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        int sign=1;
        int i=0;
        if(s.isEmpty()){
            return 0;
        }
        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            sign=s.charAt(0)=='-'?-1:1;
            i++;
        }
        return solve(s,0L,i,sign);
    }
    public int solve(String s,long n,int i,int sign){
        if(i==s.length()){
            return clamp(n*sign);
        }
        char ch=s.charAt(i);
        if(!Character.isDigit(ch)){
            return clamp(n*sign);
        }
        n = n*10 + (ch -'0');
        
        if (sign*n > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (sign*n < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return solve(s,n,i+1,sign);
    }
    private int clamp(long val) {
        if (val > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (val < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) val;
    }

}
