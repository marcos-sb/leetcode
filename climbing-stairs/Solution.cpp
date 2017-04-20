class Solution {
public:
    int climbStairs(int n) {
        if(n <= 0) return 0;

        int n_0 = 0;
        int n_1 = 1;
        int tmp;
        while(n-- > 0) {
            tmp = n_0 + n_1;
            n_0 = n_1;
            n_1 = tmp;
        }

        return n_1;
    }
};