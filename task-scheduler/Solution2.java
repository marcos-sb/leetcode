public class Solution {
    public int leastInterval(char[] tasks, int n) {
        final int[] freqs = new int['Z'-'A'+1];
        for (char t : tasks)
            freqs[t-'A']++;
        
        int maxFreq = 0;
        for (int i = 0; i < freqs.length; i++)
            maxFreq = Math.max(maxFreq, freqs[i]);
        
        int maxFreqTasks = 0;
        for (int i = 0; i < freqs.length; i++)
            if (freqs[i] == maxFreq) maxFreqTasks++;
        
        // the last interval doesn't need idle time
        final int fullIntervalLen = (maxFreq - 1) * (n+1);
        
        // once the full intervals have been filled with tasks,
        // the tasks that remain are [1] 1 task each of those with maxFreq, and
        // [2] any other task that didn't fit in the full intervals, if any
        final int res = fullIntervalLen + maxFreqTasks;
        if (res < tasks.length) return tasks.length;
        return res;
    }
}
