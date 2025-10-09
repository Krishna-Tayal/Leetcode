class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        if (m == 0) return 0L;
        if (n == 0) return 0L;

        long s = 0L; 

        
        for (int j = 0; j < m - 1; ++j) {
            long nextStart = Long.MIN_VALUE;

            long sum_j = 0L;         
            long sum_j1_prev = 0L;   

            
            for (int i = 0; i < n; ++i) {
                
                sum_j += 1L * skill[i] * mana[j];  

                
                long val = s + sum_j - sum_j1_prev;
                if (val > nextStart) nextStart = val;

                sum_j1_prev += 1L * skill[i] * mana[j+1];
            }
            s = nextStart;
        }

        long lastSum = 0L;
        for (int i = 0; i < n; ++i) lastSum += 1L * skill[i] * mana[m - 1];
        long makespan = s + lastSum;
        return makespan;
    }

}

