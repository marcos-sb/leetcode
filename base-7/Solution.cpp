class Solution {
public:
    string convertToBase7(int num) {
        stack<int> s;
        const int base = 7;
        int n = num;
        while(n / base) {
            s.push(n % base);
            n /= base;
        }

        string out = to_string(n);
        while(!s.empty()) {
            out += to_string(abs(s.top()));
            s.pop();
        }

        return out;
    }
};
