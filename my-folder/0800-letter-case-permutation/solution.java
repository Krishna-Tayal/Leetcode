class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        solve(s,list,sb,0);
        return list;
    }
    public void solve(String s,List<String> list,StringBuilder sb,int i){
        if(s.length()==sb.length()){
            list.add(sb.toString());
            i=0;
            return;
        }
        char ch=s.charAt(i);
        if(Character.isLetter(ch)){
            sb.append(Character.toLowerCase(ch));
            solve(s,list,sb,i+1);
            sb.deleteCharAt(sb.length()-1);

            sb.append(Character.toUpperCase(ch));
            solve(s,list,sb,i+1);
            sb.deleteCharAt(sb.length()-1);

        }
        else{
            sb.append(ch);
            solve(s,list,sb,i+1);
            sb.deleteCharAt(sb.length()-1);
            
        }
    }
}
