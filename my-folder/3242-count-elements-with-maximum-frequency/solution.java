class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int max=Collections.max(map.values());
        int maxfreq=0;
        for(int i : map.values()){
            if(i==max){
                maxfreq+=i;
            }
        }
        return maxfreq;
    }
}
