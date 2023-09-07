import java.util.*;

class EmployeeFreeTimes {
    public static List<Interval> employeeFreeTime(ArrayList<ArrayList<Interval>> schedule) {
        final var N = schedule.size();
        if (N == 0) return List.of();
        
        final Comparator<int[]> cmp = (a,b) ->
            Integer.compare(schedule.get(a[0]).get(a[1]).start, schedule.get(b[0]).get(b[1]).start);
        final var heap = new PriorityQueue<int[]>(cmp);
        final var res = new ArrayList<Interval>();

        for (var i = 0; i < N; i++) heap.offer(new int[]{i, 0});
        var first = heap.peek();
        var end = schedule.get(first[0]).get(first[1]).end;
        while (!heap.isEmpty()) {
            final var tmp = heap.poll();
            final var curInterval = schedule.get(tmp[0]).get(tmp[1]);
            if (tmp[1] < schedule.get(tmp[0]).size()-1) heap.offer(new int[]{tmp[0], tmp[1]+1});
            if (end < curInterval.start) res.add(new Interval(end, curInterval.start));
            end = Math.max(end, curInterval.end);
        }

        return res;
    }
}
