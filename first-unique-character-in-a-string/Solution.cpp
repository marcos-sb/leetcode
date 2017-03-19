class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char,int> char2pos;
        for(char c : s)
            char2pos[c]++;

        for(int i = 0; i < s.length(); ++i)
            if(char2pos[s[i]] == 1)
                return i;
        
        return -1;
    }
};
