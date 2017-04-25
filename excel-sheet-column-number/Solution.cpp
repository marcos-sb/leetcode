class Solution {
public:
    int titleToNumber(string s) {
        const int base = 26;
        int sum = s.front() - 'A' + 1;
        for(int i = 1; i < s.length(); ++i) {
            sum *= base;
            sum += s[i] - 'A' + 1;
        }
        return sum;
    }
};