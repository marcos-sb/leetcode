class Solution3 {
    public List<List<Integer>> permute(int[] nums) {
        final var used = new boolean[21]; // 10 - (-10) + 1 => range of values [-10,10]
        final List<List<Integer>> ret = new ArrayList<>();
        bt(nums, used, new ArrayList<Integer>(), ret);
        return ret;
    }
    
    private static void bt(int[] nums, boolean[] used, List<Integer> aux, List<List<Integer>> res) {
        if (aux.size() == nums.length) {
            res.add(new ArrayList<>(aux));
            return;
        }
        
        for (var j = 0; j < nums.length; j++) {
            final var indx = nums[j]+10;
            if (!used[indx]) {
                aux.add(nums[j]);
                used[indx] = true;
                bt(nums, used, aux, res);
                aux.remove(aux.size()-1);
                used[indx] = false;
            }
        }
    }
}
