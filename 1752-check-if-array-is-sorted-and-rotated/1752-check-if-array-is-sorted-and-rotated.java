class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        int[] dup=new int[n];
        for(int i=0;i<n;i++){
            dup[i]=nums[i];
        }
        Arrays.sort(dup);
        if(equal(dup,nums)) return true;

        for(int k=1;k<n;k++){
            int[] rot=new int[n];
            for(int i=0;i<n;i++){   
                rot[i]=dup[(i+k)%n];
            }
            if(equal(rot,nums)){
                return true;
            }
        }
        return false;
    }
    public boolean equal(int[] dup,int[] nums){
        for(int i=0;i<dup.length;i++){
            if(dup[i]!=nums[i]){
                return false;
            }
        }
        return true;
    }
}
