class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int sum = 0;
        for(int n : nums)
            sum += n;

        int sz = nums.size();
        int th_sum = sz * (sz+1) / 2;

        return th_sum - sum;
    }
};
