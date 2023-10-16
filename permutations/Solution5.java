class Solution {
    public List<List<Integer>> permute(int[] nums) {
        final var N = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(){{add(nums[0]);}});
        for (var ni = 1; ni < N; ni++) {
            final List<List<Integer>> newPerms = new ArrayList<>();
            for (final var perm : res) {
                for (var i = 0; i <= perm.size(); i++) {
                    final var newPerm = new ArrayList<Integer>();
                    if (i == 0) {
                        newPerm.add(nums[ni]);
                        newPerm.addAll(perm);
                    } else if (i == perm.size()) {
                        newPerm.addAll(perm);
                        newPerm.add(nums[ni]);
                    } else {
                        newPerm.addAll(perm.subList(0, i));
                        newPerm.add(nums[ni]);
                        newPerm.addAll(perm.subList(i, perm.size()));
                    }
                    newPerms.add(newPerm);
                }
            }
            res = newPerms;
        }
        return res;
    }
}
