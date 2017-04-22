class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int _max = INT_MIN;
        int curr_sum = 0;

        for(int n : nums) {
            if(curr_sum < 0)
                curr_sum = n;
            else
                curr_sum += n;
            _max = max(_max,curr_sum);
        }

        return _max;
    }
};