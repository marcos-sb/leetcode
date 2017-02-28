class Solution {

public:
    vector<string> findWords(vector<string>& words) {
        unordered_map<char,int> char2row = {
            {'q',0},{'w',0},{'e',0},{'r',0},{'t',0},{'y',0},{'u',0},{'i',0},{'o',0},{'p',0},
            {'a',1},{'s',1},{'d',1},{'f',1},{'g',1},{'h',1},{'j',1},{'k',1},{'l',1},
            {'z',2},{'x',2},{'c',2},{'v',2},{'b',2},{'n',2},{'m',2}
        };
        vector<string> ret;
        for(const string s : words) {
            int s_row = char2row[tolower(s[0])];
            bool ok = true;
            for(const char c : s)
                if(char2row[tolower(c)] != s_row) {
                    ok = false;
                    break;
                }
            if(ok) ret.push_back(s);
        }
        return ret;
    }
};
