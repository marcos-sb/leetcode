class Solution {
    public void sortColors(int[] nums) {
        countingSort(nums);
    }
    
    private static void countingSort(int[] nums) {
        if (nums == null) return;
        
        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;
        for (var n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        final var freqs = new int[max-min+1];
        for (var n : nums) {
            freqs[n-min]++;
        }
        
        var j = 0;
        for (var i = 0; i < freqs.length; i++) {
            while (freqs[i]-- > 0) nums[j++] = i+min;
        }
    }
}
