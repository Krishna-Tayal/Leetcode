class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        Arrays.sort(potions);
        for(int i=0;i<n;i++){
            long least= (success+spells[i] - 1)/spells[i];
            spells[i]=m - binarysearch(potions,least);
        }
        return spells;
    }
    public int binarysearch(int[] potions, long least){
        int left=0;int right=potions.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(potions[mid]<least){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }
}
