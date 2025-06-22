class Solution {
    public int leastInterval(char[] tasks, int n) {
        final var counts = new int[26];
        var maxCount = 0;
        for (var task : tasks)
            maxCount = Math.max(maxCount, ++counts[task-'A']);

        var numMaxCount = 0;
        for (var count : counts)
            if (count == maxCount) ++numMaxCount;

        return Math.max(tasks.length, (maxCount-1) * (n+1) + numMaxCount);
    }
}
