class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<int,int> counts;
        for(char c : s)
            counts[c]++;
        
        int oddPresent = 0;
        int halves = 0;
        for(auto p : counts) {
            if(p.second % 2) {
                oddPresent = 1;
                halves += p.second-1;
            } else
                halves += p.second;
        }
        
        return halves + oddPresent;
    }
};
