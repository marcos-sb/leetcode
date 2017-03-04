class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int single = 0;
        for(int n : nums)
            single ^= n;
        return single;
    }
};
