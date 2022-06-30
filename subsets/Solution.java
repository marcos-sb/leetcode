class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        final List<Integer> aux = new ArrayList<>();
        bt(nums, 0, aux, res);
        return res;
    }
    
    private static void bt(int[] nums, int i, List<Integer> curr, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        curr.add(nums[i]);
        bt(nums, i+1, curr, res);
        curr.remove(curr.size()-1);
        bt(nums, i+1, curr, res);
    }
}
