class Solution {
    public boolean isHappy(int n) {
        final var seen = new HashSet<Integer>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            var sum = 0;
            while (0 < n) {
                final var digit = n % 10;
                sum += digit*digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
