class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        final int ld = decimalDigits(low);
        final int hd = decimalDigits(high);
        final List<Integer> ret = new ArrayList<>();
        for (int _ld = ld; _ld <= hd; _ld++) { // for each length from len(low) to len(high)
            final int endDigit = 10-_ld;
            for (int d = 1; d <= endDigit; d++) { // start from digit 1
                int n = d;
                for (int k = d+1, i = 0; i < _ld-1; k++, i++) n = (n*10) + k; // append digits up to len
                if (n < low) continue;
                if (high < n) return ret;
                ret.add(n);
            }
        }
        return ret;
    }
    private static int decimalDigits(int n) { // O(1)
        int digits = 0;
        while (n > 0) {
            n /= 10;
            digits++;
        }
        return digits;
    }
}
