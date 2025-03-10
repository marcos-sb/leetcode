class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        bt(0, nums, new ArrayList<Integer>(), res);
        return res;
    }

    private static void bt(int i, int[] nums, List<Integer> aux, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(aux));
            return;
        }
        aux.add(nums[i]);
        bt(i+1, nums, aux, res);
        aux.removeLast();
        bt(i+1, nums, aux, res);
    }
}
