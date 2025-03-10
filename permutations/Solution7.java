class Solution {
    public List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        final var used = new boolean[21];
        bt(nums, used, new ArrayList<>(), res);
        return res;
    }

    private static void bt(int[] nums, boolean[] used, List<Integer> aux, List<List<Integer>> res) {
        if (aux.size() == nums.length) {
            res.add(new ArrayList<>(aux));
            return;
        }
        for (var n : nums) {
            if (used[n+10]) continue;
            used[n+10] = true;
            aux.add(n);
            bt(nums, used, aux, res);
            aux.removeLast();
            used[n+10] = false;
        }
    }
}
