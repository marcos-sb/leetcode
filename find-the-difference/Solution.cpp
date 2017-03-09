class Solution {
public:
    char findTheDifference(string s, string t) {
        unordered_map<char,int> s_counts(s.length());
        for(char c : s)
            s_counts[c]++;

        for(char c : t)
            if(!s_counts[c]) return c;
            else s_counts[c]--;

        return 0;
    }
};
