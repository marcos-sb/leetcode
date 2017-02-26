public class Solution {
    public int reverse(int x) {
        final long absx = Math.abs(x);
        long tmp = 0;
        long base = 1;
        while(absx / base > 0) {
            tmp *= 10;
            tmp += (absx % (base*10)) / base;
            base *= 10;
        }
        if(tmp < Integer.MIN_VALUE || tmp > Integer.MAX_VALUE)
            return 0;
        int _tmp = (int) tmp;
        if(x < 0) return -_tmp;
        else return _tmp;
    }
}
