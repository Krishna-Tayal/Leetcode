class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<3 && n!=1){
            return false;
        }
        return cuberoot(3,n,0);
    }
    public boolean cuberoot(int cube,int n,int power){
        if(Math.pow(cube,power)==n){
            return true;
        }
        else if(Math.pow(cube,power)>n){
            return false;
        }
        return cuberoot(3,n,power+1);
    }
}
