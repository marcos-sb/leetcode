class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int map [nums.size()+1];
        fill_n(map, nums.size()+1, 0);
        for(int n : nums)
            map[n]++;

        vector<int> ret;
        for(int i = 1; i<=nums.size(); i++)
            if(!map[i]) ret.push_back(i);

        return ret;
    }
};
