class Solution {
    public long removeZeros(long n) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            long digit=n%10;
            if(digit!=0){
                sb.append(digit);
            }
            n=n/10;
        }
        sb.reverse();
        return Long.parseLong(sb.toString());
    }
}
