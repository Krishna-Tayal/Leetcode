class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n=edges.length+1;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        int depth=dfs(list,1,0);

        return (int)(power(2,depth-1)%1000000007);
    }
    public int dfs(List<List<Integer>> list,int start,int parent){
        int d=0;

        for(int n : list.get(start)){
            if(n==parent) continue;

            d=Math.max(d,dfs(list,n,start)+1);
        }
        return d;
    } 
    private long power(long a, long b) {
    long mod = 1000000007L;
    long ans = 1;

    while (b > 0) {
        if ((b & 1) == 1)
            ans = (ans * a) % mod;

        a = (a * a) % mod;
        b >>= 1;
    }

    return ans;
}  
}