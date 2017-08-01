class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c) {
        int old_r = nums.size();
        int old_c = nums[0].size();
        if(old_r * old_c != r * c)
            return nums;

        vector<vector<int>> new_shape(r);
        for(int i = 0; i < r; ++i) {
            vector<int> vec(c);
            new_shape[i] = vec;
        }

        int i = 0;
        int j = 0;
        for(auto row : nums)
            for(int cell : row) {
                new_shape[i][j] = cell;
                j = (j + 1) % c;
                if(j == 0)
                    i = (i + 1) % r;
            }

        return new_shape;
    }
};
