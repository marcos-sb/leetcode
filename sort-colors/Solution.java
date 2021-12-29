class Solution {
    public void sortColors(int[] nums) {
        final var freqs = new int[3];
        for (var n : nums) freqs[n]++;
        
        var k = 0;
        for (var i = 0; i < freqs.length; i++)
            while (freqs[i]-- > 0) nums[k++] = i;
    }
}
