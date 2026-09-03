class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int evenCount = 0;
        int oddCount = 0;
        int min = Integer.MAX_VALUE;

        for(int val : nums1){
            min = Math.min(min,val);
            
            if(val % 2 ==0){
                evenCount++;
            }else{
                oddCount++;
            }
        }

        if(evenCount == n || oddCount == n){
            return true;
        }

        for(int val : nums1){
            if(val % 2 == 0){
                if(min % 2 == 0) return false; 
            }
        }

        return true;
    }
}