class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2]; 

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int curr = nums[i] + nums[left] + nums[right];
                if (curr == target) return target;
                if (Math.abs(curr - target) < Math.abs(closest - target)) {
                    closest = curr;
                }
                if (curr < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closest;
    }
}
