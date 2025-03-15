class Solution {
    public int[] getOrder(int[][] tasks) {
        final var N = tasks.length;
        final var indexedTasks = new int[N][3];
        for (var i = 0; i < tasks.length; i++) {
            indexedTasks[i][0] = tasks[i][0];
            indexedTasks[i][1] = tasks[i][1];
            indexedTasks[i][2] = i;
        }

        Arrays.sort(indexedTasks, (a,b) -> Integer.compare(a[0], b[0]));

        final var minHeap = new PriorityQueue<int[]>((a, b) -> {
            final var ptc = Integer.compare(a[1], b[1]);
            return ptc != 0 ? ptc : Integer.compare(a[2], b[2]);
        });
        var time = indexedTasks[0][0];
        var i = 0;
        final var res = new int[N];
        var k = 0;
        while (k < N) {
            while (i < N && indexedTasks[i][0] <= time) {
                minHeap.offer(indexedTasks[i++]);
            }
            if (!minHeap.isEmpty()) {
                final var top = minHeap.poll();
                res[k++] = top[2];
                time += top[1];
            } else {
                if (i < N) {
                    time = indexedTasks[i][0];
                }
            }
        }

        return res;
    }
}
