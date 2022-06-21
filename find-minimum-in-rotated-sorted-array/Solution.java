class Solution {
    public int findMin(int[] nums) {
        final var N = nums.length;
        if (nums == null || N == 0) return -1;
        if (N == 1) return nums[0];
        if (nums[0] < nums[N-1]) return nums[0];

        return aux(nums);
    }

    private static int aux(int[] arr) {
        final var N = arr.length;
        var lo = 0;
        var hi = N-1;

        while (lo <= hi) {
            final var mid = (hi-lo)/2 + lo;
            if (arr[mid+1] < arr[mid]) return arr[mid+1];
            if (arr[lo] <= arr[mid]) lo = mid+1;
            else hi = mid-1;
        }

        return -1;
    }
}
