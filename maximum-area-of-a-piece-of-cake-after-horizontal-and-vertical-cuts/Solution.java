class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        final var hpieces = bound(horizontalCuts, h);
        final var vpieces = bound(verticalCuts, w);
        return (int) (((long)maxSegmentLen(hpieces) * maxSegmentLen(vpieces)) % 1_000_000_007L);
    }
    private static List<Integer> bound(int[] arr, int upperBound) {
        Arrays.sort(arr);
        final var ret = new ArrayList<Integer>();
        ret.add(0);
        for (var el : arr) ret.add(el);
        ret.add(upperBound);
        return ret;
    }
    private static int maxSegmentLen(List<Integer> l) {
        if (l.size() < 2) return 0;
        var max = 0;
        var prev = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            final var curr = l.get(i);
            max = Math.max(max, curr-prev);
            prev = curr;
        }
        return max;
    }
}
