class Solution {
    public List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        bt(0, nums, res);
        return res;
    }

    private static void bt(int start, int[] nums, List<List<Integer>> res) {
        if (start == nums.length) {
            res.add(toList(nums));
            return;
        }
        for (var i = start; i < nums.length; i++) {
            swap(nums, start, i);
            bt(start+1, nums, res);
            swap(nums, start, i);
        }
    }

    private static List<Integer> toList(int[] nums) {
        final var res = new ArrayList<Integer>(nums.length);
        for (var n : nums) res.add(n);
        return res;
    }

    private static void swap(int[] nums, int i, int j) {
        final var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
