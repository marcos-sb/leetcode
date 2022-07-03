class Solution {
    public int jump(int[] nums) {
        final var N = nums.length;
        final var q = new ArrayDeque<Integer>();
        final var visited = new boolean[N];
        
        q.offer(0);
        visited[0] = true;
        var jumps = 0;
        while (!q.isEmpty()) {
            var size = q.size();
            while (0 < size--) {
                final var curr = q.poll();
                if (curr == N-1) return jumps;
                final var maxJump = Math.min(nums[curr], N-1-curr);
                for (var j = 1; j <= maxJump; j++) {
                    final var nextIdx = curr+j;
                    if (visited[nextIdx]) continue;
                    visited[nextIdx] = true;
                    q.offer(nextIdx);
                }
            }
            jumps++;
        }
        
        return -1;
    }
}
