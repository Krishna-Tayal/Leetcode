class Solution {
    public List<String> generateParenthesis(int n) {
       int open =n;
       int close=n;
       List<String> ans=new ArrayList<>();
       solve(ans,"",open,close);
       return ans; 
    }
    public void solve(List<String> ans,String op,int open,int close){
        if(open==0 && close==0){
            ans.add(op);
            return;
        }
        if(open!=0){
            String op1=op;
            op1+="(";
            solve(ans,op1,open-1,close);
        }
        if(open<close){
            String op2=op;
            op2+=")";
            solve(ans,op2,open,close-1);
        }
    }
}
