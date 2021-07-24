public class Solution {
    public double myPow(double x, int n) {
        return pow(x, (long) n);
    }
    private static double pow(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) {
            n *= -1;
            x = 1/x;
        }
        return n % 2 == 0 ? pow(x*x, n/2) : x * pow(x, n-1);
    }
}
