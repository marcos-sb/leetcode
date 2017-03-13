class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& nums) {
        unordered_map<int,int> input_order;
        for(int i = 0; i < nums.size(); ++i)
            input_order[nums[i]] = i;

        unordered_map<int,string> prizes = {
            {0,"Gold Medal"},{1,"Silver Medal"},{2,"Bronze Medal"}
        };
        for(int i = 3; i < nums.size(); ++i)
            prizes[i] = to_string(i+1);

        sort(nums.begin(), nums.end(), [](int i, int j) { return j < i; });

        vector<string> ret (nums.size());

        for(int i = 0; i < nums.size(); ++i)
            ret[input_order[nums[i]]] = prizes[i];

        return ret;
    }
};
