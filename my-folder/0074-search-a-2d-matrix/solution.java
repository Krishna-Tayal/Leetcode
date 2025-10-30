class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        int row=0;
        int col=0;

        int left=row;
        int right=m-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(matrix[mid][col] == target){
                return true;
            }
            if(matrix[mid][col] > target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        row=left-1;
        right=n-1;
        left=0;
        if(row<0 || row>=m){
            return false;
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(matrix[row][mid] == target){
                return true;
            }
            if(matrix[row][mid] > target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return false;
    }
}
