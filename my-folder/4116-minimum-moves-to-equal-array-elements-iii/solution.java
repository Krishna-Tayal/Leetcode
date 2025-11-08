class Solution {
    public int minMoves(int[] nums) {
        int max=0;
        for(int i : nums){
            if(i>max){
                max=i;
            }
        }
        int moves=0;
        for(int i : nums){
            moves+= max-i;
        }
        return moves;
    }
}
