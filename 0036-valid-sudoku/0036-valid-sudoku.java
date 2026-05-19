class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] pres=new boolean[10];
        for(int i=0;i<9;i++){
            Arrays.fill(pres,false);
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int num=board[i][j]-'0';
                if(pres[num]) return false;
                pres[num]=true;
            }
        }
        for(int i=0;i<9;i++){
            Arrays.fill(pres,false);
            for(int j=0;j<9;j++){
                if(board[j][i]=='.'){
                    continue;
                }
                int num=board[j][i]-'0';
                if(pres[num]) return false;
                pres[num]=true;
            }
        }
        for(int r=0;r<9;r+=3){
            for(int c=0;c<9;c+=3){
                Arrays.fill(pres,false);
                for(int i=r;i<(r+3);i++){
                    for(int j=c;j<(c+3);j++){
                        if(board[i][j]=='.'){
                        continue;
                        }
                        int num=board[i][j]-'0';
                        if(pres[num]) return false;
                        pres[num]=true;
                    }
                }
            }
        }
        return true;
    }
}