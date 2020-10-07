class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        final List<List<Integer>> ret = new ArrayList<>(){{ add(new ArrayList<>()); }};
        for (int i = 0; i < candidates.length && candidates[i] <= target; i++) {
            cs(candidates, target, ret, i, 0);
        }
        ret.remove(ret.size()-1);
        return ret;
    }

    public void cs(int[] candidates, int left, List<List<Integer>> combs, int start, int dfsDepth) {
        var open = combs.get(combs.size()-1);

        final var newEl = candidates[start];
        final var newLeft = left-newEl;
        if (newLeft < 0) return;
        if (newLeft == 0) {
            combs.add(new ArrayList<>(open));
            open.add(newEl);
            return;
        }

        open.add(newEl);
        for (int i = start; i < candidates.length && candidates[i] <= newLeft && i < 150 - dfsDepth; i++) {
            cs(candidates, newLeft, combs, i, dfsDepth+1);
        }
        final var newOpen = combs.get(combs.size()-1);
        newOpen.remove(newOpen.size()-1);
    }
}

