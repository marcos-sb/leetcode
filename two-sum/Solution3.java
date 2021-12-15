class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        final var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i]))
                return new int[]{i, map.get(target-nums[i])};
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
// a + b = target => a = target-b
