class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> list=new ArrayList<>();
        int place=1;
        while(n>0){
            int num=n%10;
            if(num!=0){
                list.add(num*place);
            }
            n=n/10;
            place*=10;
        }

        Collections.sort(list,Collections.reverseOrder());
        
        int[] res=new int[list.size()];
        for(int i =0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
