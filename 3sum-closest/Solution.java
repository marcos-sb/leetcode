class Solution {
    public int threeSumClosest(int[] nums, int target) {
        final var N = nums.length;
        Arrays.sort(nums);
        var closestSum = Integer.MAX_VALUE;
        for (var i = 0; i < N-2; i++) {
            if (0 < i && nums[i-1] == nums[i]) continue;
            var j = i+1;
            var k = N-1;
            while (j < k) {
                var sum = nums[i] + nums[j] + nums[k];
                if (target == sum) return target;
                if (Math.abs(sum-target) < Math.abs(closestSum-target))
                    closestSum = sum;
                if (sum < target) j++;
                else k--;
            }
        }

        return closestSum;
    }
}
