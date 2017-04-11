class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> generated;
        const int base = 10;
        int digit;
        int sq_sum;
        while(n != 1) {
            if(generated.count(n))
                return false;

            generated.insert(n);
            sq_sum = 0;
            do {
                digit = n % base;
                sq_sum += digit * digit;
            } while(n /= base);
            n = sq_sum;
        }

        return true;
    }
};
