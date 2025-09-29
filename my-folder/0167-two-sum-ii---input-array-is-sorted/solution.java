class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int left=0;int right=n-1;
        int[] index=new int[2];

        while(left<right){
            if(numbers[right]+numbers[left] == target){
                index[0]=left+1;
                index[1]=right+1;
                return index;
            }
            else if(numbers[right]+numbers[left] > target){
                right--;
            }
            else{
                left++;
            }
        }
        return new int [0];
    }
}
