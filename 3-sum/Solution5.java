class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) return List.of();
        
        final var N = nums.length;
        final var seen = new HashSet<Integer>(N);
        final Set<List<Integer>> tmp = new HashSet<>();
        for (var i = 0; i < N-2; i++)
            if (seen.add(nums[i]))
                twoSum(nums, i+1, -nums[i], tmp);
        
        return new ArrayList<>(tmp);
    }
    
    private static void twoSum(int[] nums, int l, int k, Set<List<Integer>> res) {
        final var seen = new HashSet<Integer>();
        for (var i = l; i < nums.length; i++) {
            if (seen.contains(k-nums[i])) {
                final var li = Arrays.asList(nums[i], -k, k-nums[i]);
                Collections.sort(li);
                res.add(li);
            }
            seen.add(nums[i]);
        }
    }
}
