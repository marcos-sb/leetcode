class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> uniq1;
        unordered_set<int> uniq2;

        for(int n : nums1)
            uniq1.insert(n);
        for(int n : nums2)
            uniq2.insert(n);
        for(auto it = uniq1.begin(); it != uniq1.end(); )
            if(!uniq2.count(*it))
                it = uniq1.erase(it);
            else
                ++it;

        vector<int> res;
        for(int n : uniq1)
            res.push_back(n);

        return res;
    }
};
