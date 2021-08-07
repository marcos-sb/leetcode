import java.util.NavigableMap;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;
        for (var n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        final var len = max-min+1;
        final var tree = new int[4*len];
        final var res = new ArrayList<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) res.add(0);
        for (int i = nums.length-1; i >= 0; i--) {
            final var rangeCount = query(tree, 0, len-1, 0, 0, nums[i]-min-1);
            res.set(i, rangeCount);
            update(tree, 0, len-1, 0, nums[i]-min);
        }

        return res;
    }
    
    private static int query(int[] t, int tl, int tr, int i, int l, int r) {
        if (r < l) return 0;
        if (tl == l && tr == r) return t[i];
        final var mid = tl + (tr-tl)/2;
        return query(t, tl, mid, 2*i+1, l, Math.min(r, mid)) +
            query(t, mid+1, tr, 2*i+2, Math.max(l, mid+1), r);
    }

    private static void update(int[] t, int tl, int tr, int i, int pos) {
        if (tl == tr) t[i]++;
        else {
            final var mid = tl + (tr-tl)/2;
            if (pos <= mid) update(t, tl, mid, 2*i+1, pos);
            else update(t, mid+1, tr, 2*i+2, pos);
            t[i] = t[2*i+1] + t[2*i+2];
        }
    }
}
