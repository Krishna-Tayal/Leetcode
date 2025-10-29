class Solution {
    public int smallestNumber(int n) {
        if(n<=0){
            return 1;
        }
        int bits = 32 - Integer.numberOfLeadingZeros(n);
        return (1<<bits)-1;
    }
}
