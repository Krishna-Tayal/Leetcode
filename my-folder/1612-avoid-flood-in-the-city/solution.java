class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1); 

        Map<Integer, Integer> last = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                dryDays.add(i);
            } else {
                ans[i] = -1;
                if (last.containsKey(lake)) {
                    int prevFillDay = last.get(lake);
                    Integer dryIndex = dryDays.higher(prevFillDay);
                    if (dryIndex == null) return new int[0];
                    ans[dryIndex] = lake;
                    dryDays.remove(dryIndex);
                }
                last.put(lake, i);
            }
        }
        return ans;
    }
}

