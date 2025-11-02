
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>(); 
        Arrays.sort(nums);
        int min=nums[0];
        int max=nums[n-1];
        List<Integer> numb=new ArrayList();
        for(int i : nums){
            numb.add(i);
        }
        while(min<max){
            min+=1;
            if(!numb.contains(min)){
                list.add(min);
            }
        }
        return list;
    }
}
