class Solution {
    int possible=0;int count0=0;int[] start=new int[2];
    public int uniquePathsIII(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    start[0]=i;
                    start[1]=j;
                }
                else if(grid[i][j]==0){
                    count0++;
                }
            }
        }
        solve(grid,start[0],start[1]);
        return possible;
    }
    public void solve(int[][] grid,int i,int j){
        if(!isSafe(i,j,grid.length,grid[0].length) || grid[i][j]==-1){
            return;
        }
        if(grid[i][j]==2){
            if(count0==-1){
                possible++;
            }
            return;
        }
        grid[i][j]=-1; //Visited
        count0--; 

        solve(grid,i+1,j);
        solve(grid,i-1,j);
        solve(grid,i,j-1);
        solve(grid,i,j+1);

        grid[i][j]=0;
        count0++;
    }
    public boolean isSafe(int i,int j,int n,int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
}
