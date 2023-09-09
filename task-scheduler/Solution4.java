class Solution {
    public int leastInterval(char[] tasks, int n) {
        final var N = tasks.length;
        final var freqs = new int['Z'-'A'+1];
        var maxF = 0;
        for (var t : tasks) maxF = Math.max(maxF, ++freqs[t-'A']);
        var maxFCount = 0;
        for (var f : freqs) if (f == maxFCount) maxFCount++;
        final var maxFTaskSlots = (maxF-1)*(n+1);
        final var res = maxFTaskSlots + maxFCount;
        
        return res < N ? N : res;
    }
}
//|ABiABi|AB
