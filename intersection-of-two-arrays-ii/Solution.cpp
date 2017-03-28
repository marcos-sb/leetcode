class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> ret;
        if(!nums1.size() || !nums2.size()) return ret;

        unordered_map<int,int> counts1;
        unordered_map<int,int> counts2;

        for(int n : nums1)
            counts1[n]++;
        for(int n : nums2)
            counts2[n]++;

        for(auto kv : counts1)
            if(counts2.count(kv.first))
                for(int i = 0; i < min(counts1[kv.first],counts2[kv.first]); ++i)
                    ret.push_back(kv.first);

        return ret;
    }
};
