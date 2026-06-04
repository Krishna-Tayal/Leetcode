class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;
        while(num1<=num2){
            count+=waive(num1);
            num1++;
        }
        return count;
    }
    public int waive(int num){
        int count=0;
        while(num>100){
            int last=num%10;
            int mid=(num%100)/10;
            int first=(num%1000)/100;

            if((last> mid && first>mid)|| (last<mid && first<mid)){
                count++;
            }
            num/=10;
        }
        return count;
    }
}