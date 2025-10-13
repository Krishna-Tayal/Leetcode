class Solution {
    public boolean isPowerOfTwo(int n) {
        return check(n,0);
    }
    public boolean check(int n, int k){
        if(Math.pow(2,k) > n){
            return false;
        }
        else if(Math.pow(2,k) == n){
            return true;
        }
        return check(n,++k);
    }
}
