class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        List<Integer> small=new ArrayList<>();
        List<Integer> large=new ArrayList<>();

        for(int i : nums){
            if(i<pivot){
                small.add(i);
            }
            else if(i>pivot){
                large.add(i);
            }
        }
        for(int i=0;i<small.size();i++){
            nums[i]=small.get(i);
        }
        for(int i=small.size();i<n-large.size();i++){
            nums[i]=pivot;
        }
        int j=0;
        for(int i=n-large.size();i<n;i++){
            nums[i]=large.get(j++);
        }
        return nums;
    }
}