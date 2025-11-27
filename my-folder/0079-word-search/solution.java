class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(solve(board,n,m,word,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean solve(char[][] board,int n,int m,String word,int i,int j){
        if(word.length()==0){
            return true;
        }
        if(!isSafe(i,j,n,m) || board[i][j]!=word.charAt(0)){
            return false;
        }
        char ch=board[i][j];
        board[i][j]='0';
        String temp=word.substring(1);
        if(solve(board,n,m,temp,i+1,j)){
            return true;
        }
        else if(solve(board,n,m,temp,i-1,j)){
            return true;
        }
        else if(solve(board,n,m,temp,i,j-1)){
            return true;
        }
        else if(solve(board,n,m,temp,i,j+1)){
            return true;
        }
        else{
            board[i][j]=ch;
            return false;
        }
    }
    public boolean isSafe(int i,int j,int n,int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
}
