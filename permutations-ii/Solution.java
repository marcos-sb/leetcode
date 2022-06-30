class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        final Set<List<Integer>> res = new HashSet<>();
        final List<Integer> curr = new ArrayList<>();
        final var used = new boolean[nums.length];
        
        bt(nums, used, curr, res);
        
        return new ArrayList<>(res);
    }
    
    private static void bt(int[] arr, boolean[] used, List<Integer> curr, Set<List<Integer>> res) {
        if (curr.size() == arr.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for (var j = 0; j < arr.length; j++) {
            if (used[j]) continue;
            used[j] = true;
            curr.add(arr[j]);
            bt(arr, used, curr, res);
            curr.remove(curr.size()-1);
            used[j] = false;
        }
    }
}
