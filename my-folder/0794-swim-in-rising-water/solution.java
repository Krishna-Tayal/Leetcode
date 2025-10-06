class Solution {
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], r = cur[1], c = cur[2];
            if (visited[r][c]) continue;       
            visited[r][c] = true;
            
            if (r == n - 1 && c == n - 1) return time;
            
            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                
                int nextTime = Math.max(time, grid[nr][nc]);
                pq.offer(new int[]{nextTime, nr, nc});
            }
        }
        return -1;
    }
}

