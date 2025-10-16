class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        int[] cnt = new int[value];

        for (int num : nums) {
            cnt[Math.floorMod(num, value)]++;
        }

        for (int x = 0; x <= n; x++) {
            int r = x % value;
            if (cnt[r] > 0) cnt[r]--;
            else return x;
        }

        return n + 1;
    }
}

