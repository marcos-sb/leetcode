class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k >= arr.length)
            return 0;
        
        final var freq = new HashMap<Integer, Integer>(arr.length);
        for (var n : arr) freq.put(n, freq.getOrDefault(n, 0)+1);
        
        final var freqCount = new HashMap<Integer, Integer>(arr.length);
        for (var f : freq.values()) freqCount.put(f, freqCount.getOrDefault(f, 0)+1);
        
        int uniqueCount = freq.size();
        for (var entry : freqCount.entrySet()) {
            final var currFreq = entry.getKey();
            final var currFreqCount = entry.getValue();
            if (k - currFreq * currFreqCount >= 0) {
                k -= currFreq * currFreqCount;
                uniqueCount -= currFreqCount;
            } else {
                uniqueCount -= k / currFreq;
                break;
            }
        }
        
        return uniqueCount;
    }
}
