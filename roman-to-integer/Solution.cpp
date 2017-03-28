class Solution {
public:
    int romanToInt(string s) {
        if(!s.length()) return 0;

        unordered_map<char,int> value = {
            {'I',1},{'V',5},{'X',10},{'L',50},{'C',100},{'D',500},{'M',1000}
        };

        int prev = 0;
        int curr;
        int total = 0;
        for(int i = 0; i < s.length(); ++i) {
            curr = value[s[i]];
            if(prev && prev < curr) {
                total += curr - prev;
                prev = 0;
            } else {
                total += prev;
                prev = curr;
            }
        }

        return total + prev;
    }
};
