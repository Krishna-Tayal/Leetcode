class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        long currentSum = 0;
        HashSet<Integer> window = new HashSet<>();
        
        int left = 0;
        for (int right = 0; right < n; right++) {
            // Add the current element to the window
            while (window.contains(nums[right])) {
                // Remove elements from the left until the duplicate is removed
                currentSum -= nums[left];
                window.remove(nums[left]);
                left++;
            }
            
            // Add the current element to the sum and set
            currentSum += nums[right];
            window.add(nums[right]);
            
            // Check if the window size equals k
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                
                // Slide the window
                currentSum -= nums[left];
                window.remove(nums[left]);
                left++;
            }
        }
        
        return maxSum;
    }
}
