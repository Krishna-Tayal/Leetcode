class Solution {
    public int distinctPoints(String s, int k) {
        int n = s.length();
        
        int[] preX = new int[n+1], preY = new int[n+1];
        for (int i = 0; i < n; ++i) {
            preX[i+1] = preX[i];
            preY[i+1] = preY[i];
            char c = s.charAt(i);
            if (c == 'U') preY[i+1]++;
            else if (c == 'D') preY[i+1]--;
            else if (c == 'L') preX[i+1]--;
            else if (c == 'R') preX[i+1]++;
        }

        
        int[] sufX = new int[n+1], sufY = new int[n+1];
        for (int i = n-1; i >= 0; --i) {
            sufX[i] = sufX[i+1];
            sufY[i] = sufY[i+1];
            char c = s.charAt(i);
            if (c == 'U') sufY[i]++;
            else if (c == 'D') sufY[i]--;
            else if (c == 'L') sufX[i]--;
            else if (c == 'R') sufX[i]++;
        }

        
        HashSet<Long> seen = new HashSet<>();
        for (int i = 0; i <= n - k; ++i) {
            int x = preX[i] + sufX[i + k];
            int y = preY[i] + sufY[i + k];
            long key = (((long)x) << 32) ^ (y & 0xffffffffL);
            seen.add(key);
        }
        return seen.size();
    }
}
