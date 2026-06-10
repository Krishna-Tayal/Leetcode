class Solution {
    static class Node {
        long value;
        int l, r;

        Node(long value, int l, int r) {
            this.value = value;
            this.l = l;
            this.r = r;
        }
    }

    int[][] maxST;
    int[][] minST;
    int[] log;
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        buildSparseTables(nums);

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> Long.compare(b.value, a.value));

        for (int l = 0; l < n; l++) {
            long val = queryValue(l, n - 1);
            pq.offer(new Node(val, l, n - 1));
        }

        long ans = 0;

        while (k-- > 0 && !pq.isEmpty()) {
            Node cur = pq.poll();

            ans += cur.value;

            if (cur.r > cur.l) {
                int newR = cur.r - 1;
                long newVal = queryValue(cur.l, newR);
                pq.offer(new Node(newVal, cur.l, newR));
            }
        }

        return ans;
    }
    private void buildSparseTables(int[] nums) {
        int n = nums.length;

        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int K = log[n] + 1;

        maxST = new int[K][n];
        minST = new int[K][n];

        for (int i = 0; i < n; i++) {
            maxST[0][i] = nums[i];
            minST[0][i] = nums[i];
        }

        for (int j = 1; j < K; j++) {
            int len = 1 << j;

            for (int i = 0; i + len <= n; i++) {
                maxST[j][i] = Math.max(
                    maxST[j - 1][i],
                    maxST[j - 1][i + (len >> 1)]
                );

                minST[j][i] = Math.min(
                    minST[j - 1][i],
                    minST[j - 1][i + (len >> 1)]
                );
            }
        }
    }

    private long queryValue(int l, int r) {
        int len = r - l + 1;
        int j = log[len];

        int mx = Math.max(
            maxST[j][l],
            maxST[j][r - (1 << j) + 1]
        );

        int mn = Math.min(
            minST[j][l],
            minST[j][r - (1 << j) + 1]
        );

        return (long) mx - mn;
    }
}