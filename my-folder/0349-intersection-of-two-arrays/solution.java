import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to reduce hash work & memory
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }

        // Put elements of the smaller array into a set
        Set<Integer> seen = new HashSet<>();
        for (int x : nums1) {
            seen.add(x);
        }

        // Collect intersection in a set to avoid duplicates
        Set<Integer> resSet = new HashSet<>();
        for (int y : nums2) {
            if (seen.contains(y)) {
                resSet.add(y);
            }
        }

        // Convert result set to int[]
        int[] res = new int[resSet.size()];
        int i = 0;
        for (int v : resSet) {
            res[i++] = v;
        }
        return res;
    }
}

