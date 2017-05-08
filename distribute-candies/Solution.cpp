class Solution {
public:
    int distributeCandies(vector<int>& candies) {
        unordered_set<int> candy_types;
        for(int type : candies)
            candy_types.insert(type);

        return min(candy_types.size(), candies.size()/2);
    }
};