class Solution {
    public int smallestNumber(int n, int t) {
        if(product(n)%t == 0){
            return n;
        }
        else{
            return smallestNumber(n+1,t);
        }
    }
    public int product(int n){
        int p=1;
        while(n>0){
            p = p * (n%10);
            n = n/10;
        }
        return p;
    }
}