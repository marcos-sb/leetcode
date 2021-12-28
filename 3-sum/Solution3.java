class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        final Set<List<Integer>> set = new HashSet<>();
        for (var i = 0; i < nums.length-2; i++) {
            final var a = nums[i];
            final var seen = new HashSet<Integer>();
            for (var j = i+1; j < nums.length; j++) {
                final var b = nums[j];
                if (seen.contains(-a-b)) {
                    final var l = Arrays.asList(a,b,-a-b);
                    Collections.sort(l);
                    set.add(l);
                }
                seen.add(b);
            }
        }
        
        final List<List<Integer>> res = new ArrayList<>();
        for (var l : set) res.add(l);
        
        return res;
    }
}
// a + b + c = 0 => c = -a - b
// or: for (var a : nums) twoSum(nums, -a)
