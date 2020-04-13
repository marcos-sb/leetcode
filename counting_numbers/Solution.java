package counting_numbers;

class Solution {
    public int countElements(int[] arr) {
        final var freqs = new int[1002];
        for (var n : arr) {
            freqs[n]++;
        }
        var count = 0;
        for (var n : arr) {
            if (freqs[n+1] > 0) count++;
        }
        return count;
    }
}
