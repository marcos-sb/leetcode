class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // todo: sanitice inputs
        final List<List<Integer>> res = new ArrayList<>();
        final List<Integer> curr = new ArrayList<>();
        
        Arrays.sort(candidates);
        bt(candidates, 0, target, curr, res);
        
        return res;
    }
    
    private static void bt(int[] arr, int i, int rem, List<Integer> curr, List<List<Integer>> res) {
        if (rem == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i == arr.length) return;
        
        for (var j = i; j < arr.length; j++) {
            if (rem-arr[j] < 0) break;
            if (j == i || arr[j-1] != arr[j]) {
                curr.add(arr[j]);
                bt(arr, j+1, rem-arr[j], curr, res);
                curr.remove(curr.size()-1);
            }
        }
    }
}
