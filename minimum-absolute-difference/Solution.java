class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        final var n = arr.length;

        Arrays.sort(arr);

        var minAbsDiff = Integer.MAX_VALUE;
        for (var i = 1; i < n; ++i) {
            minAbsDiff = Math.min(minAbsDiff, arr[i] - arr[i-1]);
        }

        final List<List<Integer>> res = new ArrayList<>(n);
        for (var i = 1; i < n; ++i) {
            final var arrI = arr[i];
            final var arrI_1 = arr[i-1];
            if (arrI - arrI_1 == minAbsDiff)
                res.add(List.of(arrI_1, arrI));
        }

        return res;
    }
}
