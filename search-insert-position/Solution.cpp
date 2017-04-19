class Solution {
private:
    int almost_bs(vector<int>& nums, int lo, int hi, int target) {
        if (hi < lo) return -1;

        const int mid = (hi-lo)/2 + lo;
        int bs_res = mid;
        if (nums[mid] < target) {
            bs_res = almost_bs(nums,mid+1,hi,target);
            if (bs_res < 0) return mid+1;
        } else if(nums[mid] > target) {
            bs_res = almost_bs(nums,lo,mid-1,target);
            if (bs_res < 0) return mid;
        }

        return bs_res;
    }

public:
    int searchInsert(vector<int>& nums, int target) {
        return almost_bs(nums,0,nums.size()-1, target);
    }
};