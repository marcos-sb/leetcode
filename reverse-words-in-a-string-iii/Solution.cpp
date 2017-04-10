class Solution {
public:
    // in place reverse
    void swap(string& s, int from, int to) {
        char tmp;
        while(from < to) {
            tmp = s[from];
            s[from] = s[to];
            s[to] = tmp;
            ++from; --to;
        }
    }

    string reverseWords(string& s) {
        int k = 0;
        int next_w_pos = 0;
        while(k < s.length()) {
            if(isspace(s[k])) {
                swap(s,next_w_pos,k-1);
                next_w_pos = k+1;
            }
            ++k;
        }
        swap(s,next_w_pos,k-1);

        return s;
    }
};
