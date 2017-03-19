class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(!prices.size()) return 0;

        int buyDay = 0;
        int earnings = 0;
        for(int today = 0; today < prices.size()-1; ++today) {
            if(prices[today] > prices[today+1]) {
                if(buyDay < today) { // sell today if we had stock
                    earnings += prices[today] - prices[buyDay];
                    buyDay = -1;
                }
                buyDay = today+1; // buy tomorrow
            }
        }
        if(buyDay < prices.size())
            earnings += prices.back() - prices[buyDay];

        return earnings;
    }
};
