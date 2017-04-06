class Solution {
private:
    int _best = 0;

    const int _mp(vector<int>& prices, int pos, int _min) {
        if(pos < prices.size()) {
            const int _max = _mp(prices, pos+1, min(_min, prices[pos]));
            const int new_max = max(_max,prices[pos]);
            _best = max(new_max - _min, _best);

            return new_max;
        }
        return 0;
    }

public:
    int maxProfit(vector<int>& prices) {
        _mp(prices, 0, INT_MAX);
        return _best;
    }
};
