class Solution {
    public int totalMoney(int n) {
        int weeks=n/7;
        int days=n%7;
        int lastMonday=weeks+1;
        int amount=0;
        while(weeks>0){
            amount += 7*((weeks+(weeks+6))/2);
            weeks--;
        }
        System.out.println(amount);
        if(days%2==0){
            amount+= days/2*(lastMonday+(lastMonday+days-1));
        }
        else{
            amount+= days*((lastMonday+(lastMonday+days-1))/2);
        }
        return amount;
    }
}
