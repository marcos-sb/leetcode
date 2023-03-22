class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        final var N = l.length;
        final var res = new ArrayList<Boolean>();
        
        seq:
        for (var i = 0; i < N; i++) {
            final var li = l[i];
            final var ri = r[i];
            final var minmax = minmax(nums, li, ri);
            final var len = ri-li+1;
            if ((minmax[1]-minmax[0]) % (len-1) != 0) {
                res.add(false);
                continue;
            }
            final var cd = (minmax[1]-minmax[0]) / (len-1);
            if (cd == 0) {
                res.add(true);
                continue;
            }
            final var seen = new HashSet<Integer>();
            for (var j = li; j <= ri; j++) seen.add(nums[j]);
            for (var m = minmax[0]; m <= minmax[1]; m += cd) {
                if (!seen.remove(m)) {
                    res.add(false);
                    continue seq;
                }
            }
            res.add(true);
        }

        return res;
    }

    private static int[] minmax(int[] nums, int lo, int hi) {
        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;
        for (var i = lo; i <= hi; i++) {
            final var n = nums[i];
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        return new int[]{min, max};
    }
}
