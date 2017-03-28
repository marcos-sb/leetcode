class Solution {
private:
    void reverseStr(string& s, int from, int to) {
        char tmp;
        int i = from;
        int j = to >= s.length() ? s.length() : to;
        j -= 1;
        while(i < j) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            ++i; --j;
        }
    }

public:
    string reverseStr(string s, int k) {
        if(!s.length() || k <= 0) return s;

        for(int i = 0; i < s.length(); i+=2*k)
            reverseStr(s,i,i+k);

        return s;
    }
};
