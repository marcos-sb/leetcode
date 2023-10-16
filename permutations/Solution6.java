class Solution {
    public List<List<Integer>> permute(int[] nums) {
        final var N = nums.length;
        final var used = new boolean[N];
        final List<List<Integer>> res = new ArrayList<>();
        bt(nums, used, new ArrayList<Integer>(), res); // O(N*N!)
        return res;
    }

    private static void bt(int[] nums, boolean[] used, List<Integer> perm, List<List<Integer>> res) {
        final var N = nums.length;
        if (perm.size() == N) { // true N! times
            res.add(new ArrayList<>(perm)); // O(N)
            return;
        }
        for (var i = 0; i < N; i++) {
            if (used[i]) continue;
            perm.add(nums[i]);
            used[i] = true;
            bt(nums, used, perm, res);
            perm.remove(perm.size()-1);
            used[i] = false;
        }
    }
}
