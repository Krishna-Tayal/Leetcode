class Solution {
    public boolean isGood(int[] nums) {
        int max=0;
        for(int i : nums){
            max=Math.max(max,i);
        }
        if(max+1!=nums.length){
            return false;
        }
        int[] count=new int[nums.length+1];
        for(int i : nums){
            count[i]++;
        }
        for(int i=0;i<count.length;i++){
            if(i!=max && count[i]>1){
                return false;
            }
        }
        return count[max]==2;
    }
}