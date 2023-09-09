import java.util.*;

public class MeetingRooms{
    public static int minMeetingRooms(List<Interval> intervals) {
        final var N = intervals.size();
        final var minHeap = new PriorityQueue<Integer>();
        
        final Comparator<Interval> cmp = (a,b) -> Integer.compare(a.start, b.start);
        Collections.sort(intervals, cmp);

        minHeap.offer(intervals.get(0).end);
        for (var i = 1; i < intervals.size(); i++) {
            final var cur = intervals.get(i);
            if (minHeap.peek() <= cur.start) minHeap.poll();
            minHeap.offer(cur.end);
        }

        return minHeap.size();
    }
}