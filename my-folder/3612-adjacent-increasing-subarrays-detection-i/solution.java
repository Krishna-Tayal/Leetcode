class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (n < 2 * k) {
            return false;
        }
        for (int i = 0; i <= n - 2 * k; i++) {
            if (IsIncreasing(nums, i, k) && IsIncreasing(nums, i + k, k)) {
                return true;
            }
        }
        return false;
    }

    public boolean IsIncreasing(List<Integer> nums, int start, int len) {
        for (int j = start; j <= start + len - 2; j++) {
            if (nums.get(j + 1) <= nums.get(j)) {
                return false;
            }
        }
        return true;
    }
}

