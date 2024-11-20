class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        
        if (k == 0) {
            Arrays.fill(result, 0);
            return result;
        }
        
        int start = k > 0 ? 1 : n + k; // Start index for summation
        int end = k > 0 ? k : n - 1;  // End index for summation
        
        int sum = 0;
        // Initial sum calculation
        for (int i = start; i <= end; i++) {
            sum += code[i % n];
        }
        
        // Populate result
        for (int i = 0; i < n; i++) {
            result[i] = sum;
            // Slide the window
            sum -= code[(start++) % n];
            sum += code[(++end) % n];
        }
        
        return result;
    }
}
