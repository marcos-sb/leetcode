class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res;
        if(numRows >= 1)
            res.push_back({1});
        if(numRows >= 2)
            res.push_back({1,1});

        for(int n = 3; n <= numRows; ++n) {
            vector<int> lastLevel = res.back();
            vector<int> currLevel;
            currLevel.push_back(1);
            for(int i = 1; i < n-1; ++i)
                currLevel.push_back(lastLevel[i-1] + lastLevel[i]);
            currLevel.push_back(1);
            res.push_back(currLevel);
        }

        return res;
    }
};
