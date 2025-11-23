class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            if(n%10 != 0){
                sb.append(n%10);
            }
            n=n/10;
        }
        if(sb.isEmpty()){
            return 0;
        }
        long x=Long.parseLong(sb.reverse().toString());
        long sum=0;
        long num=x;
        while(num>0){
            sum+=num%10;
            num=num/10;
        }
        return sum*x;
    }
}
