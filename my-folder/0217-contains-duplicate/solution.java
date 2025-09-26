class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(Integer key : map.keySet()){
            if(map.get(key) >= 2){
                return true;
            }
        }
        return false;
    }
}
