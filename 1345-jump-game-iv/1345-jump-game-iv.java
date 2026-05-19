class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.putIfAbsent(arr[i],new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        boolean[] vis=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        vis[0]=true;
        int count=0;
        q.add(0);

        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                int i=q.poll();
                if(i==n-1) return count;
                if (i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.add(i - 1);
                }
                if (i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.add(i + 1);
                }
                if (map.containsKey(arr[i])) {
                    for (int j : map.get(arr[i])) {
                        if (!vis[j]) {
                            vis[j] = true;
                            q.add(j);
                        }
                    }
                    map.get(arr[i]).clear();
                }
            }
            count++;
        }
        return count;
    }
}