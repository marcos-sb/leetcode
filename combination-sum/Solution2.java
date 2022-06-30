class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        final List<List<Integer>> res = new ArrayList<>();
        final List<Integer> curr = new ArrayList<>();
        bt(candidates, 0, target, curr, res);
        return res;
    }
    
    private static void bt(int[] arr, int i, int rem, List<Integer> curr, List<List<Integer>> res) {
        if (i == arr.length) return;
        
        if (rem == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for (var j = i; j < arr.length; j++) {
            if (0 <= rem - arr[j]) {
                curr.add(arr[j]);
                bt(arr, j, rem-arr[j], curr, res);
                curr.remove(curr.size()-1);
            } else return;
        }
    }
}
