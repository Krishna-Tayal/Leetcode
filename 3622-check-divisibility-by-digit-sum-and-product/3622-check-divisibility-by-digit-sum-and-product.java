class Solution {
    public boolean checkDivisibility(int n) {
        return n%(sum(n)+product(n))==0;
    }
    public int sum(int n){
        int s=0;
        while(n>0){
            s+=n%10;
            n=n/10;
        }
        return s;
    }
    public int product(int n){
        int p=1;
        while(n>0){
            p*=n%10;
            n=n/10;
        }
        return p;
    }
}