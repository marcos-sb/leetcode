package how_many_numbers_are_smaller_than_the_current_number;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        final var freqs = new int [102];
        for (int n : nums) {
            freqs[n+1]++;
        }
        for (int i = 1; i < freqs.length; i++) {
            freqs[i] += freqs[i-1];
        }
        final var res = new int [nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = freqs[nums[i]];
        }
        return res;
    }
}
