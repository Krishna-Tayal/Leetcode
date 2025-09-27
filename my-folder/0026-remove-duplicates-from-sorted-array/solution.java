class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0;

       for (int check = 1; check < nums.length; check++) {
            if (nums[check] != nums[left]) {
                left++;        
                nums[left] = nums[check];
            }
       }
       return left+1;
    }
}
