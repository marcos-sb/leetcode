class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        int k;
        int i = -1;
        int j;
        bool repeated_end = false;

        for(j = 1; j < s.length(); ++j) {
            k = j;
            i = -1;
            while(k < s.length()) {
                if(++i >= j) i = 0;
                if(s[i] != s[k]) {
                    repeated_end = false;
                    break;
                }
                ++k;
                repeated_end = true;
            }
            if(repeated_end) break;
        }

        return i == j-1;
    }
};