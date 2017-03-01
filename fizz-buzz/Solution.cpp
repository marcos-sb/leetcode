class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> ret;
        ret.reserve(n);
        const string f = "Fizz";
        const string b = "Buzz";
        const string fb = f + b;
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0) {
                if(i % 5 == 0) ret.push_back(fb);
                else ret.push_back(f);
            } else
                if(i % 5 == 0) ret.push_back(b);
                else ret.push_back(to_string(i));
        }
        return ret;
    }
};
