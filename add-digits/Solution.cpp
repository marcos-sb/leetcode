class Solution {
public:
    int addDigits(int num) {
        int n = num;
        long i;
        int sum;
        while(n > 9) {
            sum = 0;
            i = 1L;
            while(n / i > 0) {
                sum += (n % (i*10)) / i;
                i *= 10;
            }
            n = sum;
        }

        return n;
    }

    int addDigits2(int num) {
        return
            num == 0     ? 0 :
            num % 9 == 0 ? 9 : num % 9;
    }
};
