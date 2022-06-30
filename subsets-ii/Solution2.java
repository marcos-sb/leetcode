class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        final Set<List<Integer>> res = new HashSet<>();
        final List<Integer> curr = new ArrayList<>(nums.length);
        
        bt(nums, 0, curr, res);
        
        return new ArrayList<>(res);
    }
    
    private static void bt(int[] arr, int i, List<Integer> curr, Set<List<Integer>> res) {
        if (i == arr.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        curr.add(arr[i]);
        bt(arr, i+1, curr, res);
        curr.remove(curr.size()-1);
        bt(arr, i+1, curr, res);
    }
}
