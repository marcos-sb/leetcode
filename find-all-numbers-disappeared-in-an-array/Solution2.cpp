class Solution2 {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int pos;
        for(int n : nums) {
            pos = abs(n)-1;
            if(nums[pos] > 0) nums[pos] *= -1;
        }
        vector<int> ret;
        for(int i = 0; i<nums.size(); i++)
            if(nums[i] > 0)
                ret.push_back(i+1);

        return ret;
    }
};
