class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if (n < 2) return 0;
        int low = 0;
        int high = n / 2;

        while (low < high) {
            int mid = (low + high + 1) / 2; 
            if (isPossible(nums, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low; 
    }

    private boolean isPossible(List<Integer> nums, int k) {
        int n = nums.size();
        if (n < 2 * k) return false;

        int[] inc = new int[n];
        inc[n - 1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            if (nums.get(i + 1) > nums.get(i)) inc[i] = inc[i + 1] + 1;
            else inc[i] = 1;
        }

        for (int a = 0; a <= n - 2 * k; ++a) {
            if (inc[a] >= k && inc[a + k] >= k) return true;
        }
        return false;
    }
}

