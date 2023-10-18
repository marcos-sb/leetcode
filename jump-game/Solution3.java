class Solution {
    public boolean canJump(int[] nums) {
        final var N = nums.length;
        if (N == 1) return true;
        
        final var maxHeap = new PriorityQueue<Integer>((i,j) -> Integer.compare(nums[j], nums[i]));
        maxHeap.offer(0);
        while (!maxHeap.isEmpty()) {
            final var currI = maxHeap.poll();
            final var jump = nums[currI];
            nums[currI] = 0;
            if (N-1 <= currI + jump) return true;
            for (var j = 1; j <= jump && currI+j < N; j++) { // O(N*log(N))
                if (nums[currI+j] == 0) continue;
                maxHeap.offer(currI+j); // O(log(N))
            }
        }
        
        return false;
    }
}
