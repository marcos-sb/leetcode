public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) return new ArrayList<>();
        
        Arrays.sort(nums);
        final Set<List<Integer>> ret = new HashSet<>();
        subsetsHelper(nums, 0, new ArrayList<>(), ret);

        final List<List<Integer>> retList = new ArrayList<>();
        for (List<Integer> l : ret) retList.add(l);
        return retList;
    }

    private static void subsetsHelper(int[] nums, int i, List<Integer> currSet, Set<List<Integer>> ret) {
        if (i == nums.length) {
            ret.add(new ArrayList(currSet));
            return;
        }

        final int el = nums[i];
        currSet.add(el);
        subsetsHelper(nums, i+1, currSet, ret);
        currSet.remove(currSet.size()-1);
        subsetsHelper(nums, i+1, currSet, ret);
    }
}
