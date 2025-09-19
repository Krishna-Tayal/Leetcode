class Solution {
    public int maxArea(int[] height) {
       int n= height.length;
       int l=0,r=n-1,max=0;

       while(l<r){
        int area=(Math.min(height[l],height[r]))*(r-l);
        max= Math.max(area,max);

        if(height[l]<height[r]){
            l++;
        }
        else if(height[l]>height[r]){
            r--;
        }
        else{
            l++;
        }
       }
       return max;
    }
}
