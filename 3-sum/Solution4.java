class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // a + b + c = 0 <=> c = -(a+b)
        Arrays.sort(nums);
        final List<List<Integer>> res = new ArrayList<>();
        for (var i = 0; i < nums.length; i++) {
            var seen = new HashSet<Integer>();
            final var a = nums[i];
            if (i == 0 || nums[i-1] != nums[i])
                for (var j = i+1; j < nums.length; j++) {
                    final var b = nums[j];
                    if (seen.contains(-a-b)) {
                        res.add(List.of(a,b,-a-b));
                        while (j < nums.length-1 && nums[j] == nums[j+1])
                            j++;
                    }
                    seen.add(b);
                }
        }
        
        return res;
    }
}
