class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int zeros = 0;
        int k = 0;
        int tmp;
        for(int n : nums)
            if(!n)
                ++zeros;
            else
                nums[k++] = n;

        int i = nums.size()-1;
        while(zeros-- > 0)
            nums[i--] = 0;
    }
};
