class Solution {
    public int minimumDeviation(int[] nums) {
        final var pq = new PriorityQueue<Integer>((a,b) -> b - a);
        var min = Integer.MAX_VALUE;
        for (var n : nums) {
            var _n = n;
            if (_n % 2 != 0) _n *= 2;
            pq.offer(_n);
            min = Math.min(min, _n);
        }
      
        var minDiff = Integer.MAX_VALUE;
        while (true) {
            final var front = pq.poll();
            final var diff = front - min;
            minDiff = Math.min(minDiff, diff);
            if (front % 2 != 0) break;
            pq.add(front / 2);
            min = Math.min(min, front / 2);
        }

        return minDiff;
    }
}
