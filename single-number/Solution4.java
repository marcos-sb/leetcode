class Solution {

    public int singleNumber(int[] nums) {
        final var seen = new HashSet<Integer>(nums.length / 2 + 1);
        for (var n : nums) if (!seen.add(n)) seen.remove(n);
        return seen.toArray(new Integer[0])[0];
    }
}
