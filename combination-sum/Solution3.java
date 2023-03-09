class Solution {
    private List<List<Integer>> res;

    public Solution() {
        res = new ArrayList<>();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        bt(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void bt(int[] candidates, int i, int remaning, List<Integer> open) {
        if (remaning == 0) {
            res.add(new ArrayList<>(open));
            return;
        }

        for (var j = i; j < candidates.length; j++) {
            if (0 <= remaning-candidates[j]) {
                open.add(candidates[j]);
                bt(candidates, j, remaning-candidates[j], open);
                open.remove(open.size()-1);
            }
        }
    }
}
