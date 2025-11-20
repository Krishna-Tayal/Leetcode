class Solution {
    public int search(int[] nums, int target) {
        return binarysearch(nums,0,nums.length-1,target);
    }
    public int binarysearch(int[] nums,int left,int right,int target){
        int mid=left+(right-left)/2;
        if(left>right){
            return -1;
        }
        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]>target){
            return binarysearch(nums,left,mid-1,target);
        }
        else{
            return binarysearch(nums,mid+1,right,target);
        }
    }
}
