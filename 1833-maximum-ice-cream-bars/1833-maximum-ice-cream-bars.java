class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ice = 0;
        for (int i : costs) {
            if (i <= coins) {
                ice++;
                coins -= i;
            }
        }
        return ice;
    }
}