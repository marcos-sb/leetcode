class Solution {
    public List<List<Integer>> permute(int[] nums) {
        final var n = nums.length;
        final var seen = new boolean[21];
        final List<List<Integer>> res = new ArrayList<>();

        bt(nums, seen, new ArrayList<>(), res);

        return res;
    }

    private static void bt(int[] nums, boolean[] seen, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (var num : nums) {
            if (seen[10+num]) continue;
            curr.add(num);
            seen[10+num] = true;
            bt(nums, seen, curr, res);
            curr.remove(curr.size()-1);
            seen[10+num] = false;
        }
    }
}
