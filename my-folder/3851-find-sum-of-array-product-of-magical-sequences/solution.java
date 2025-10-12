class Solution {
    static final int MOD = 1_000_000_007;

    static long modPow(long a, long e) {
        long r = 1 % MOD;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) r = (r * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return r;
    }

    static long inv(long x) {
        return modPow(x, MOD - 2);
    }

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        int M = m;

        long[] fact = new long[M + 1];
        long[] invFact = new long[M + 1];
        fact[0] = 1;
        for (int i = 1; i <= M; ++i) fact[i] = fact[i - 1] * i % MOD;
        invFact[M] = inv(fact[M]);
        for (int i = M - 1; i >= 0; --i) invFact[i] = invFact[i + 1] * (i + 1) % MOD;

        long[][] numsPow = new long[n][M + 1];
        for (int j = 0; j < n; ++j) {
            numsPow[j][0] = 1;
            long base = (nums[j] % MOD + MOD) % MOD;
            for (int c = 1; c <= M; ++c) numsPow[j][c] = numsPow[j][c - 1] * base % MOD;
        }

        int K = Math.min(k, M);
        long[][][] cur = new long[M + 1][M + 1][K + 1];
        long[][][] next = new long[M + 1][M + 1][K + 1];
        cur[0][0][0] = 1;

        for (int pos = 0; pos < n; ++pos) {
            for (int u = 0; u <= M; ++u)
                for (int c = 0; c <= M; ++c)
                    Arrays.fill(next[u][c], 0L);

            for (int used = 0; used <= M; ++used) {
                for (int carry = 0; carry <= M; ++carry) {
                    for (int ones = 0; ones <= K; ++ones) {
                        long val = cur[used][carry][ones];
                        if (val == 0) continue;
                        int remainMax = M - used;
                        for (int c = 0; c <= remainMax; ++c) {
                            int newUsed = used + c;
                            int sum = carry + c;
                            int bit = sum & 1;
                            int newOnes = ones + bit;
                            if (newOnes > K) break;
                            int newCarry = sum >> 1;
                            if (newCarry > M) continue;
                            long add = val * numsPow[pos][c] % MOD * invFact[c] % MOD;
                            next[newUsed][newCarry][newOnes] += add;
                            if (next[newUsed][newCarry][newOnes] >= MOD) next[newUsed][newCarry][newOnes] -= MOD;
                        }
                    }
                }
            }

            long[][][] tmp = cur;
            cur = next;
            next = tmp;
        }

        long ansCoeff = 0;
        for (int carry = 0; carry <= M; ++carry) {
            int carryOnes = Integer.bitCount(carry);
            if (carryOnes > K) continue;
            for (int ones = 0; ones <= K; ++ones) {
                if (ones + carryOnes != k) continue;
                long val = cur[M][carry][ones];
                if (val == 0) continue;
                ansCoeff += val;
                if (ansCoeff >= MOD) ansCoeff -= MOD;
            }
        }

        long[] factor = new long[M + 1];
        factor[0] = 1;
        for (int i = 1; i <= M; i++) factor[i] = factor[i - 1] * i % MOD;

        long ans = ansCoeff * factor[M] % MOD;
        return (int) ans;
    }
}
