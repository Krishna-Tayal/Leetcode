class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] C=new int[n];
        Arrays.fill(C,0);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int a=A[i];
            int b=B[i];
            map.put(a,map.getOrDefault(a,0)+1);
            map.put(b,map.getOrDefault(b,0)+1);

            for(int k : map.values()){
                if(k>=2){
                    C[i]++;
                }
            }
        }
        return C;
    }
}