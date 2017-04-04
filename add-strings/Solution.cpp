class Solution {
public:
    string addStrings(string num1, string num2) {
        int kmax = max(num1.length(), num2.length()) - 1;
        int kmin = min(num1.length(), num2.length()) - 1;
        const string& shorter = num1.length() < num2.length() ? num1 : num2;
        const string& longer = num1.length() < num2.length() ? num2 : num1;
        int sum;
        int carry = 0;
        const char zero = '0';
        string res (kmax+1,' ');
        while (kmin >= 0) {
            sum = shorter[kmin] - zero + longer[kmax] - zero + carry;
            carry = sum / 10;
            res[kmax] = static_cast<char>(sum % 10 + zero);
            --kmin; --kmax;
        }

        while(kmax >= 0) {
            sum = longer[kmax] - zero + carry;
            res[kmax] = static_cast<char>(sum % 10 + zero);
            carry = sum / 10;
            --kmax;
        }

        if(carry)
            return static_cast<char>(carry + zero) + res;

        return res;
    }
};
