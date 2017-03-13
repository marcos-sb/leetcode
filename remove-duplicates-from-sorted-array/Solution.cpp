class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(!nums.size())
            return nums.size();

        int r_pos = 1;
        int w_pos = 0;
        while(r_pos < nums.size()) {
            if(nums[r_pos] == nums[w_pos])
                r_pos++;
            else
                nums[++w_pos] = nums[r_pos++];
        }

        return w_pos+1;
    }
};
