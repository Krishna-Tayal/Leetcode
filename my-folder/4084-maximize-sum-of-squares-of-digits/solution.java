class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num*9 < sum){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<num;i++){
            int digit=Math.min(9,sum);
            sb.append(digit);
            sum-=digit;
        }
        return sb.toString();
    }
}
