class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.length() == 0) return 0;
        if(needle.length() > haystack.length()) return -1;

        bool in = false;
        for(int k = 0; k < haystack.length() - needle.length() + 1; ++k) {
            if(needle.front() == haystack[k]) {
                in = true;
                for(int i = 1; i < needle.length(); ++i)
                    if(needle[i] != haystack[i+k]) {
                        in = false;
                        break;
                    }
            }
            if(in) return k;
        }

        return -1;
    }
};