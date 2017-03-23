class Solution {
public:
    bool isAnagram(string s, string t) {
        const int sz = 'z' - 'a' + 1;
        int counts_s [sz] = {0};
        int counts_t [sz] = {0};

        for(char c : s)
            counts_s[c - 'a']++;
        for(char c : t)
            counts_t[c - 'a']++;

        for(int i = 0; i < sz; ++i)
            if(counts_s[i] != counts_t[i])
                return false;

        return true;
    }
};
