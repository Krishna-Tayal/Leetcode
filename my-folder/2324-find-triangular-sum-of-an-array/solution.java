class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int[] newnums= nums;
        while(newnums.length!=1){
            newnums=calculate(newnums);
        }
        return newnums[0];
    }
    private int[] calculate(int[] cal){
        int i=0;
        int[] newcal=new int[cal.length-1];
        while(i<cal.length-1){
            newcal[i]= (cal[i]+cal[i+1]) %10;
            i++;
        }
        return newcal;
    }
}
