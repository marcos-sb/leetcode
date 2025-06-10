class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        final List<List<Integer>> res = new ArrayList<>();
        bt(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private static void bt(
        int[] candidates,
        int i,
        int target,
        List<Integer> partialSum,
        List<List<Integer>> res
    ) {
        if (target == 0) {
            res.add(new ArrayList<>(partialSum));
            return;
        }

        if (i == candidates.length) return;

        for (var j = i; j < candidates.length; ++j) {
            final var num = candidates[j];
            if (target - num < 0) break;
            if (i < j && candidates[j - 1] == num) continue;
            partialSum.add(num);
            bt(candidates, j + 1, target - num, partialSum, res);
            partialSum.remove(partialSum.size() - 1);
        }
    }
}
