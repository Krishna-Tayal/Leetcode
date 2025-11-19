class Solution {
    public void reverseString(char[] s) {
        List<Character> list=new ArrayList<>();
        for(char ch : s){
            list.add(ch);
        }
        re(list);
        for(int i=0;i<s.length;i++){
            s[i]=list.get(i);
        }
    }
    void re(List<Character> list){
        if(list.size()==0){
            return;
        }
        char ch=list.get(0);
        list.remove(list.get(0));
        re(list);
        insert(list,ch);
    }
    void insert(List<Character> list,char ch){
            list.add(ch);
            return;
    }
}
