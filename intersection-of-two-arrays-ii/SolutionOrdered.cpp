class SolutionOrdered {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> ret;
        if(!nums1.size() || !nums2.size()) return ret;

        int i = 0;
        int j = 0;
        while(i < nums1.size() && j < nums2.size()) {
            if(nums1[i] < nums2[j]) {
                ++i;
            } else if(nums1[i] > nums2[j]) {
                ++j;
            } else {
                ret.push_back(nums1[i]);
                ++i; ++j;
            }
        }

        return ret;
    }
};
