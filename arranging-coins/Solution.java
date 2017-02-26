public class Solution {
    public int arrangeCoins(int n) {
        if(n < 1) return 0;
        final long val = (long) n;
        return (int) (Math.sqrt(val*8+1) - 1) / 2;
    }
}
