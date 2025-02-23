class Solution {
    public boolean isHappy(int n) {
        var slow = n;
        var fast = n;
        do {
            slow = sumSquares(slow);
            fast = sumSquares(sumSquares(fast));
        } while (1 < fast && fast != slow);
        return 1 == fast;
    }

    private int sumSquares(int n) {
        var sum = 0;
        while (0 < n) {
            final var mod10 = n % 10;
            sum += mod10*mod10;
            n /= 10;
        }
        return sum;
    }
}
