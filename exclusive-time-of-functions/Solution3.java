class Solution {
    static class LogEntry {
        static int[] of(String logEntry) {
            final var logArr = logEntry.split(":");
            final var logArrInt = new int[3];
            logArrInt[0] = Integer.parseInt(logArr[0]);
            logArrInt[1] = logArr[1].charAt(0) == 's' ? 0 : 1;
            logArrInt[2] = Integer.parseInt(logArr[2]);
            return logArrInt;
        }
    }

    // The idea is to subtract the execution time of called functions (nested)
    // from the execution time of calling functions when this 'end', and simply
    // calculate the timestamp difference between the 'start' and 'end'
    // function events for every log entry.
    public int[] exclusiveTime(int n, List<String> logs) {
        final var L = logs.size();
        final var stack = new ArrayDeque<int[]>();
        final var res = new int[n];
        for (var log : logs) {
            final var logEntry = LogEntry.of(log);
            if (logEntry[1] == 0) stack.push(logEntry);
            else { // 'end'
                final var stLogEntry = stack.pop();
                final var execTime = logEntry[2] - stLogEntry[2] + 1;;
                res[stLogEntry[0]] += execTime;
                if (stack.isEmpty()) continue;
                res[stack.peek()[0]] -= execTime;
            }
        }

        return res;
    }
}
