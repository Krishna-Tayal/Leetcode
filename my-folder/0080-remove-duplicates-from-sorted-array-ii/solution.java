class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int write = 0; 

        for (int i = 0; i < n; i++) {
            if (write < 2 || nums[i] != nums[write - 2]) {
                nums[write++] = nums[i];
            }
        }
        return write;
    }
}
