class Solution {
public:
    bool detectCapitalUse(string word) {
        /*
         * {st:init, lower case, upper case once, upper case only, fail}
         * {in:lower case, upper case}
         * int[st][in] fsm
         * st_n+1 = in + st_n
         */
        int fsm[][2] = {
            {1,2},{1,4},{1,3},{4,3},{4,4}
        };

        int st = 0;
        for(char c : word) {
            st = fsm[st][isupper(c)];
            if(st == 4) {
                return false;
            }
        }

        return true;
    }
};
