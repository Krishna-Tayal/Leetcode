class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1; // To track consecutive characters

        for (int i = 0; i < s.length(); i++) {
            // Add the current character to the result
            result.append(s.charAt(i));

            // Check the length of the result to avoid IndexOutOfBoundsException
            if (result.length() >= 3) {
                int len = result.length();
                // Check if the last three characters are the same
                if (result.charAt(len - 1) == result.charAt(len - 2) &&
                    result.charAt(len - 2) == result.charAt(len - 3)) {
                    // Remove the last character to avoid three consecutive characters
                    result.deleteCharAt(len - 1);
                }
            }
        }

        return result.toString();
    }
}
