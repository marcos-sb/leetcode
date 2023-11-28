class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final var N = candidates.length;
        
        Arrays.sort(candidates);
        
        final List<List<Integer>> res = new ArrayList<>();
        bt(0, candidates, target, new ArrayList<Integer>(), res);

        return res;
    }

    private static void bt(int i, int[] nums, int target, List<Integer> aux, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(aux));
            return;
        }
        final var N = nums.length;
        if (i == N || target < 0) return;

        for (var j = i; j < N; j++) {
            aux.add(nums[j]);
            bt(j, nums, target-nums[j], aux, res);
            aux.remove(aux.size()-1);
        }
    }
}
