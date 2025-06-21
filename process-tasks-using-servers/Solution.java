class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        final var n = servers.length;
        final var m = tasks.length;
        final var free = new PriorityQueue<int[]>((a,b) -> {
            final var byWeight = Integer.compare(a[0], b[0]);
            if (byWeight != 0) return byWeight;
            return Integer.compare(a[1], b[1]);
        });
        final var busy = new PriorityQueue<int[]>((a,b) -> {
            final var byFreeTime = Integer.compare(a[0], b[0]);
            if (byFreeTime != 0) return byFreeTime;
            final var byWeight = Integer.compare(a[1], b[1]);
            if (byWeight != 0) return byWeight;
            return Integer.compare(a[2], b[2]);
        });

        for (var i = 0; i < n; ++i)
            free.offer(new int[]{servers[i], i});

        final var ans = new int[m];
        var currTime = 0;
        for (var j = 0; j < m; ++j) {
            currTime = Math.max(currTime, j);

            while (!busy.isEmpty() && busy.peek()[0] <= currTime) {
                final var busyServer = busy.poll();
                final var freeServer = new int[]{busyServer[1], busyServer[2]};
                free.offer(freeServer);
            }

            while (free.isEmpty()) {
                final var busyServer = busy.poll();
                currTime = busyServer[0];
                final var freeServer = new int[]{busyServer[1], busyServer[2]};
                free.offer(freeServer);
            }

            final var currFreeServer = free.poll();
            final var currBusyServer = new int[]{currTime + tasks[j], currFreeServer[0], currFreeServer[1]};
            busy.offer(currBusyServer);

            ans[j] = currFreeServer[1];
        }

        return ans;
    }
}
