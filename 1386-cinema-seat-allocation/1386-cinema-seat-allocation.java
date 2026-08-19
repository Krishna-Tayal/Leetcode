class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Set<Integer> rows = new HashSet<>();

        Map<Integer, Set<Integer>> reserved = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            rows.add(row);

            if (col >= 2 && col <= 9) {
                reserved.putIfAbsent(row, new HashSet<>());
                reserved.get(row).add(col);
            }
        }

        int ans = (n - rows.size()) * 2;
        for (int row : rows) {

            Set<Integer> seats = reserved.getOrDefault(row, new HashSet<>());

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for (int i = 2; i <= 5; i++) {
                if (seats.contains(i)) {
                    left = false;
                    break;
                }
            }

            for (int i = 4; i <= 7; i++) {
                if (seats.contains(i)) {
                    middle = false;
                    break;
                }
            }

            for (int i = 6; i <= 9; i++) {
                if (seats.contains(i)) {
                    right = false;
                    break;
                }
            }

            if (left && right) {
                ans += 2;
            } else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }
}