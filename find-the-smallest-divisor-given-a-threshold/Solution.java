class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        var left = 1;
        var right = 0;
        for (var num : nums) {
            right = Math.max(right, num);
        }

        while (left < right) {
            final var mid = left + (right-left) / 2;
            if (underThreshold(nums, threshold, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean underThreshold(int[] nums, int th, int divisor) {
        var sum = 0;
        for (var num : nums) {
            sum += (num + divisor - 1) / divisor;
            if (th < sum) {
                return false;
            }
        }

        return true;
    }
}
