class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        final var N = nums.length;
        final List<List<Integer>> res = new ArrayList<>(1 << N);
        bt(0, nums, new ArrayList<>(), res);
        
        return res;
    }

    private static void bt(int i, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        bt(i+1, nums, curr, res);
        curr.remove(curr.size()-1);
        bt(i+1, nums, curr, res);
    }
}
