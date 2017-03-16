class Solution {
public:
    int minMoves(vector<int>& nums) {
        int _min = INT_MAX;
        for(int n : nums)
            _min = min(n,_min);

        int moves = 0;
        for(int n : nums)
            moves += abs(n - _min);

        return moves;
    }
};
