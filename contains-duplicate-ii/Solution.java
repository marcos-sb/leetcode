class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final var lastSeen = new HashMap<Integer, Integer>();
        final var n = nums.length;

        for (var i = 0; i < n; ++i) {
            final var num = nums[i];
            if (lastSeen.containsKey(num) && (i - lastSeen.get(num) <= k)) {
                return true;
            }
            lastSeen.put(num, i);
        }

        return false;
    }
}
