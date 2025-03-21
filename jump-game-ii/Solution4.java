class Solution {
    public int jump(int[] nums) {
        final var N = nums.length;
        final var minJumps = new int[N];
        Arrays.fill(minJumps, Integer.MAX_VALUE);

        minJumps[0] = 0;
        var lo = 0;

        outer:
        while (lo < N) {
            for (var i = lo + nums[lo]; lo < i; --i) {
                if (N <= i) continue;
                minJumps[i] = Math.min(minJumps[i], minJumps[lo]+1);
                if (N-1 == i) break outer;
            }
            ++lo;
        }

        return minJumps[N-1];
    }
}
