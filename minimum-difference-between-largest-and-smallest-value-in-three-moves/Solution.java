class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;

        final var top4 = new PriorityQueue<Integer>();
        final var bot4 = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));
        for (var n : nums) {
            top4.offer(n);
            bot4.offer(n);
            if (top4.size() > 4) top4.poll();
            if (bot4.size() > 4) bot4.poll();
        }
        final var min4 = new int[4];
        final var max4 = new int[4];
        int i = 3;
        while (!bot4.isEmpty()) min4[i--] = bot4.poll();
        i = 0;
        while (!top4.isEmpty()) max4[i++] = top4.poll();
        
        return minDiff(min4, max4);
    }
    
    private static int minDiff(int[] min4, int[] max4) {
        var minDiff = Integer.MAX_VALUE;
        for (var i = 0; i < 4; i++)
            minDiff = Math.min(minDiff, max4[i] - min4[i]);
        return minDiff;
    }
}
