import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        if (power == null || power.length == 0) return 0L;

        Map<Long, Long> damageMap = new HashMap<>();
        for (int p : power) {
            long val = p;
            damageMap.put(val, damageMap.getOrDefault(val, 0L) + val);
        }

        List<Long> keys = new ArrayList<>(damageMap.keySet());
        Collections.sort(keys);

        int n = keys.size();
        long[] dp = new long[n];
        dp[0] = damageMap.get(keys.get(0));

        for (int i = 1; i < n; i++) {
            long val = keys.get(i);
            long take = damageMap.get(val);
            int j = binarySearchLastLeq(keys, i - 1, val - 3L);
            if (j >= 0) take += dp[j];
            dp[i] = Math.max(dp[i - 1], take);
        }

        return dp[n - 1];
    }

    private int binarySearchLastLeq(List<Long> keys, int endIdx, long target) {
        int lo = 0, hi = endIdx;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (keys.get(mid) <= target) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}

