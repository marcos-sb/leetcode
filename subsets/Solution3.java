class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        final var N = nums.length;
        final List<List<Integer>> res = new ArrayList<>(1 << N);
        for (var len = 0; len <= N; len++)
            bt(0, len, nums, new ArrayList<>(), res);
        
        return res;
    }

    private static void bt(int i, int ssLen, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == ssLen) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for (var j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            bt(j+1, ssLen, nums, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}
