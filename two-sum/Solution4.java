class Solution {
    public int[] twoSum(int[] nums, int target) {
        // a + b = target => a = target - b
        final var seenIndex = new HashMap<Integer, Integer>();
        final var len = nums.length;
        for (var i = 0; i < len; i++) {
            final var a = nums[i];
            if (seenIndex.containsKey(a))
                return new int[]{i, seenIndex.get(a)};
            seenIndex.put(target-a, i);
        }
        return new int[]{-1,-1};
    }
}
