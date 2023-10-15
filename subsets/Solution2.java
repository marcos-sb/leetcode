class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        final var N = nums.length;
        final List<List<Integer>> res = new ArrayList<>(1 << N);
        res.add(new ArrayList<>());

        for (var n : nums) {
            final List<List<Integer>> newSubsets = new ArrayList<>();
            for (var ss : res) {
                final var newSubset = new ArrayList<>(ss);
                newSubset.add(n);
                newSubsets.add(newSubset);
            }
            res.addAll(newSubsets);
        }

        return res;
    }
}
