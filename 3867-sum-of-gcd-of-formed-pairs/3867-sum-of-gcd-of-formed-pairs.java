class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int mx=0;
        int[] prefixGcd=new int[n];
        
        for(int i=0;i<n;i++){
            mx=Math.max(mx,nums[i]);
            prefixGcd[i]=gcd(nums[i],mx);
        }
        Arrays.sort(prefixGcd);
        int left=0;int right=n-1;
        long sum=0;

        while(left<right){
            sum+=gcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        return sum;
    }
    public int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}