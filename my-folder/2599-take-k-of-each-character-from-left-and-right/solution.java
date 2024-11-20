class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] totalCount = new int[3]; // Total count of 'a', 'b', 'c'
        
        // Count total occurrences of each character
        for (char ch : s.toCharArray()) {
            totalCount[ch - 'a']++;
        }
        
        // If any character is less than k, return -1
        if (totalCount[0] < k || totalCount[1] < k || totalCount[2] < k) {
            return -1;
        }
        
        int[] currentCount = new int[3]; // Count of 'a', 'b', 'c' in the current window
        int maxWindowLength = 0;
        int left = 0;
        
        // Sliding window to find the maximum removable window
        for (int right = 0; right < n; right++) {
            currentCount[s.charAt(right) - 'a']++;
            
            // Shrink the window if it causes any character count to fall below k
            while ((totalCount[0] - currentCount[0] < k) ||
                   (totalCount[1] - currentCount[1] < k) ||
                   (totalCount[2] - currentCount[2] < k)) {
                currentCount[s.charAt(left) - 'a']--;
                left++;
            }
            
            // Update the maximum window length
            maxWindowLength = Math.max(maxWindowLength, right - left + 1);
        }
        
        // Calculate the minimum minutes
        return n - maxWindowLength;
    }
}
