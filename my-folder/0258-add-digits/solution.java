class Solution {
    public int addDigits(int num) {
        if(num/10 == 0){
            return num;
        }
        return addDigits(sum(num));
    }
    public int sum(int n){
        int s=0;
        while(n>0){
            int d=n%10;
            s+=d;
            n=n/10;
        }
        return s;
    }
}
