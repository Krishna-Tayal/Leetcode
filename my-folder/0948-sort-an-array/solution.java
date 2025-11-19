class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
    }
    public void mergesort(int[] nums,int start,int end){
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;
        mergesort(nums,start,mid);
        mergesort(nums,mid+1,end);
        merge(nums,start,mid,end);
    }
    public void merge(int[] nums,int start,int mid,int end){
        int[] arr=new int[end-start+1];
        int i=start;
        int j=mid+1;
        int idx=0;
        while(i<=mid && j<=end){
            if(nums[i]<=nums[j]){
                arr[idx++]=nums[i];
                i++;
            }
            else{
                arr[idx++]=nums[j];
                j++;
            }
        }
        while(i<=mid){
            arr[idx++]=nums[i];
            i++;
        }
        while(j<=end){
            arr[idx++]=nums[j];
            j++;
        }
        for(int a=0;a<arr.length;a++){
            nums[start+a]=arr[a];
        }
    }
}
