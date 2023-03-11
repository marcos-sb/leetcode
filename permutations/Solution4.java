class Solution {
    private final List<List<Integer>> res;
    
    public Solution() {
        res = new ArrayList<>();
    }

    public List<List<Integer>> permute(int[] nums) {
        final var N = nums.length;
        final var used = new boolean[N];
        permute(nums, used, new ArrayList<>(N));
        return res;
    }

    private void permute(int[] nums, boolean[] used, List<Integer> open) {
        final var N = nums.length;
        if (open.size() == N) {
            res.add(new ArrayList<>(open));
            return;
        }

        for (var i = 0; i < N; i++) {
            if (used[i]) continue;
            open.add(nums[i]);
            used[i] = true;
            permute(nums, used, open);
            used[i] = false;
            open.remove(open.size()-1);
        }
    }
}
