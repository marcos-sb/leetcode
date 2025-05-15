class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        final var n = nums.length;

        Arrays.sort(nums);

        final List<List<Integer>> res = new ArrayList<>();
        for (var i = 0; i < n-2; ++i) {
            if (0 < i && nums[i-1] == nums[i]) {
                continue;
            }

            var left = i+1;
            var right = n-1;
            var target = -nums[i];
            while (left < right) {
                final var sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    // Skip duplicate elements for left
                    while (left < right && nums[left] == nums[left+1]) left++;
                    // Skip duplicate elements for right
                    while (left < right && nums[right] == nums[right-1]) right--;
                    ++left; --right;
                } else if (sum < target) {
                    ++left;
                } else {
                    --right;
                }
            }
        }

        return res;
    }
}
