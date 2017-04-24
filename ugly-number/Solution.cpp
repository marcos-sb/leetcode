class Solution {
public:
    bool isUgly(int num) {
        if(num <= 0) return false;

        const int divs [] = {2,3,5};
        for(const int div : divs)
            while(num % div == 0)
                num /= div;

        return num == 1;
    }
};