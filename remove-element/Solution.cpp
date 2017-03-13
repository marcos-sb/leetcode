class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int k = 0;
        int vals = 0;
        for (int n : nums) {
            if (n == val) vals++;
            else nums[k++] = n;
        }

        return nums.size() - vals;
    }
};
