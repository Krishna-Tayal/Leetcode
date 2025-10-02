class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int totaldrank=0;
        int totalempty=0;
        int full=numBottles;

        while(full>0){
            totaldrank+=full;
            totalempty+=full;
            full=0;

            while(totalempty>=numExchange){
                full++;
                totalempty-=numExchange;
                numExchange++;

            }
        }
        return totaldrank;
    }
}
