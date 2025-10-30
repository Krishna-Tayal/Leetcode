class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        int duplicate = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Count how many numbers <= mid
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }

            if (count > mid) {
                duplicate = mid;     // potential duplicate
                right = mid - 1;     // search left half
            } else {
                left = mid + 1;      // search right half
            }
        }
        return duplicate;
    }
}
