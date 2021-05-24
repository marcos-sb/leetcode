class Solution {
    public boolean isIdealPermutation(int[] nums) {
        if (nums.length <= 1) return true;
        
        var local = 0;
        var prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            final var curr = nums[i];
            if (prev > curr) local++;
            prev = curr;
        }
        
        final var global = inversions(nums, 0, nums.length-1, new int[nums.length]);
        
        return local == global;
    }
    
    private static int inversions(int[] nums, int lo, int hi, int[] aux) {
        if (lo == hi) return 0;
        
        final var mid = (hi-lo)/2 + lo;
        return inversions(nums, lo, mid, aux) + inversions(nums, mid+1, hi, aux) +
            merge(nums, lo, mid, hi, aux); 
    }
    
    private static int merge(int[] nums, int lo, int mid, int hi, int[] aux) {
        var inversions = 0;
        var i = lo;
        var j = mid+1;
        for (var k = lo; k <= hi; k++) {
            if (i > mid) aux[k] = nums[j++];
            else if (j > hi) aux[k] = nums[i++];
            else if (nums[i] > nums[j]) {
                aux[k] = nums[j++];
                inversions += mid-i + 1;
            } else aux[k] = nums[i++];
        }
        
        for (var k = lo; k <= hi; k++)
            nums[k] = aux[k];
        
        return inversions;
    }
}
