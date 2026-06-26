import java.util.*;

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        // Coordinate Compression
        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int id = 1;
        for (int x : sorted) {
            if (!map.containsKey(x)) {
                map.put(x, id++);
            }
        }

        Fenwick bit = new Fenwick(id + 2);
        long ans = 0;

        for (int x : prefix) {
            int idx = map.get(x);

            // Count previous prefix sums < current prefix sum
            ans += bit.query(idx - 1);

            // Insert current prefix sum
            bit.update(idx, 1);
        }

        return ans;
    }

    static class Fenwick {
        int[] tree;

        Fenwick(int n) {
            tree = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < tree.length) {
                tree[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }
}