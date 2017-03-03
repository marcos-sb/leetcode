class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int max_ones = 0;
        int curr_max = 0;
        for_each(nums.begin(), nums.end(), [&,nums](int num) {
            if(num) curr_max++;
            else {
                max_ones = std::max(curr_max, max_ones);
                curr_max = 0;
            }
        });

        return std::max(curr_max, max_ones);
    }
};
