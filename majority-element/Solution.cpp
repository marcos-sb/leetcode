class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map<int,int> el2count;
        for(int n : nums)
            el2count[n]++;

        int half = nums.size() / 2;
        for(auto p : el2count)
            if(el2count[p.first] > half)
                return p.first;

        return -1;
    }
};
