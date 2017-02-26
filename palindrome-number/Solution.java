public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        long base = 1;
        int count = 0;
        while(x / base != 0) {
            base *= 10;
            count++;
        }
        base /= 10;
        int rbase = 10;
        for(int i = 0; i<count/2; i++) {
            if((x / base) % 10 != (x % rbase) / (rbase / 10))
                return false;
            base /= 10;
            rbase *= 10;
        }
        return true;
    }
}
