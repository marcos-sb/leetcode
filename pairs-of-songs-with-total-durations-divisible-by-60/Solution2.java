class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        final var mods60 = new int[time.length];
        for (int i = 0; i < time.length; i++)
            mods60[i] = time[i] % 60;
        
        var count = 0;
        final var freqs = new int[60];
        for (int i = 0; i < mods60.length; i++) {
            if (mods60[i] == 0) count += freqs[0];
            else count += freqs[60-mods60[i]];
            freqs[mods60[i]]++;
        }
        
        return count;
    }
}
