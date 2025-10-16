class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<4 && n!=1){
            return false;
        }
        return fouroot(4,n,0);
    }
    public boolean fouroot(int four,int n,int power){
        if(Math.pow(four,power)==n){
            return true;
        }
        else if(Math.pow(four,power)>n){
            return false;
        }
        return fouroot(4,n,power+1);
    }
}
    
