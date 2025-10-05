class Solution {
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0) return res;
        int m = heights.length, n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        Deque<int[]> pacQ = new ArrayDeque<>();
        Deque<int[]> atlQ = new ArrayDeque<>();

        
        for (int r = 0; r < m; r++) {
           
            pacQ.add(new int[]{r, 0});
            pac[r][0] = true;
            
            atlQ.add(new int[]{r, n - 1});
            atl[r][n - 1] = true;
        }
        for (int c = 0; c < n; c++) {
            
            pacQ.add(new int[]{0, c});
            pac[0][c] = true;
            
            atlQ.add(new int[]{m - 1, c});
            atl[m - 1][c] = true;
        }

        bfs(heights, pacQ, pac, m, n);
        bfs(heights, atlQ, atl, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    private void bfs(int[][] heights, Deque<int[]> queue, boolean[][] visited, int m, int n) {
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (heights[nr][nc] >= heights[r][c]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}
