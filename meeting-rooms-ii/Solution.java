class Solution {
    public int minMeetingRooms(int[][] intervals) {
        final Comparator<int[]> cmp = (a,b) -> Integer.compare(a[0], b[0]);
        Arrays.sort(intervals, cmp);
        
        final var pq = new PriorityQueue<Integer>();
        pq.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (pq.peek() <= intervals[i][0]) pq.poll();
            pq.offer(intervals[i][1]);
        }
        
        return pq.size();
    }
}
