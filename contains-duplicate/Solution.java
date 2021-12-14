class Solution {
    public boolean containsDuplicate(int[] nums) {
        final var set = new HashSet<Integer>();
        for (var n : nums) if (!set.add(n)) return true;
        return false;
    }
}
