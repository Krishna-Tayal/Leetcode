class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        int totalDrank = 0;
        int empty = 0;
        
        int full = numBottles;
        while (full > 0) {
            // Drink all full bottles
            totalDrank += full;
            empty += full;
            full = 0;
            
            // Exchange empty bottles for new full ones
            if (empty >= numExchange) {
                full = empty / numExchange;
                empty = empty % numExchange;
            }
        }
        
        return totalDrank;
    }
};
