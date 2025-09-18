class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        int start = 0, end = 0;   // bounds of best palindrome

        for (int center = 0; center < n; center++) {
            // Odd length
            int l = center, r = center;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l > end - start) { start = l; end = r; }
                l--; r++;
            }

            // Even length
            l = center; r = center + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l > end - start) { start = l; end = r; }
                l--; r++;
            }
        }
        return s.substring(start, end + 1);
    }
}

