class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        final var mods60 = new int[time.length];
        for (int i = 0; i < time.length; i++)
            mods60[i] = time[i] % 60;
        
        var count = 0;
        final Map<Integer, Integer> freqs = new HashMap<>();
        for (int i = 0; i < mods60.length; i++) {
            count += freqs.getOrDefault(60-mods60[i],0);
            if (mods60[i] == 0) count += freqs.getOrDefault(0, 0);
            freqs.put(mods60[i], freqs.getOrDefault(mods60[i], 0)+1);
        }
        
        return count;
    }
}
