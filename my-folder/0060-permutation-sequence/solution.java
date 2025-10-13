class Solution {
    public String getPermutation(int n, int k) {
        int[] fact=new int[n+1];
        fact[0]=1;
        for(int i=1;i<=n;i++){
            fact[i]= fact[i-1] * i;
        }
        k=k-1;
        List<Integer> numbers=new ArrayList<>();
        for(int i=1;i<=n;i++){
            numbers.add(i);
        }
        StringBuilder sb=new StringBuilder();
        buildpermutation(numbers,k,fact,sb);
        return sb.toString();
    }
    public void buildpermutation(List<Integer> numbers, int k,int[] fact, StringBuilder sb){
        if(numbers.isEmpty()){
            return;
        }
        int n=numbers.size();
        int idx=k / fact[n-1];
        sb.append(numbers.get(idx));
        numbers.remove(idx);
        k=k%fact[n-1];
        buildpermutation(numbers,k,fact,sb);
    }

}
