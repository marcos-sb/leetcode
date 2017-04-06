class Solution {
public:
    string toHex(int num) {
        unordered_map<int,char> to_hex = {
            {10,'a'},{11,'b'},{12,'c'},{13,'d'},{14,'e'},{15,'f'}
        };
        for(int i = 0; i < 10; ++i)
            to_hex[i] = static_cast<char>('0' + i);

        unsigned int n = num;
        const int base = 16;
        stack<int> st;
        while(n > 15) {
            st.push(n % base);
            n /= base;
        }

        string s;
        s += to_hex[n];
        while(!st.empty()) {
            s += to_hex[st.top()];
            st.pop();
        }

        return s;
    }
};
