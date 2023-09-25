import java.util.*;

class ScheduleTask {
    public static int tasks(List<List<Integer>> taskList) {
        final var N = taskList.size();
        final var minHeap = new PriorityQueue<Integer>();
        taskList.sort(Comparator.comparingInt(l -> l.get(0)));
        minHeap.offer(taskList.get(0).get(1));
        for (var i = 1; i < N; i++) {
            final var t = taskList.get(i);
            if (minHeap.peek() <= t.get(0)) minHeap.poll();
            minHeap.offer(t.get(1));
        }
        return minHeap.size();
    }
}
