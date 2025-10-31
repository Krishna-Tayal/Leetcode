class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        List<Integer> list=new ArrayList<>();
        int[] ans=new int[2];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 2){
                list.add(entry.getKey());
            }
        }
        for(int i=0;i<2;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}
