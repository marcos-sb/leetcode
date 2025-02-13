class Solution {
    public int majorityElement(int[] nums) {
        final var freqs = new HashMap<Integer, Integer>();
        var max = 0;
        var majority = 0;
        for (var n : nums) {
            final var c = freqs.getOrDefault(n, 0) + 1;
            freqs.put(n, c);
            if (max < c) {
                max = c;
                majority = n;
            }
        }
        return majority;
    }
}
