class Solution {
    public int maxBalancedSubarray(int[] nums) {
        int length = nums.length;
        if(length ==1) return 0;

        Map<String,Integer> seen = new HashMap<>();
        int xor = 0 , evenCount=0 , oddCount=0;
        int maxLen =0;

        seen.put("0#0" , -1);

        for(int j=0 ; j<length ; j++){
            xor ^= nums[j];
            if(nums[j] % 2 ==0) evenCount++;
            else oddCount++;

            int checkCount = evenCount - oddCount;
            String key = xor + "#" + checkCount;

            if(seen.containsKey(key)){
                maxLen = Math.max(maxLen , j-seen.get(key));
            }else{
                seen.put(key,j);
            }
        }
        return maxLen;
    }
}
