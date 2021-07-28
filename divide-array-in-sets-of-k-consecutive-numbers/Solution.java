import java.util.SortedMap;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        final SortedMap<Integer, Integer> freqs = new TreeMap<>();
        for (int n : nums) freqs.put(n, freqs.getOrDefault(n, 0)+1); // O(n*logn)

        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) { // O(n)
            final int num = entry.getKey();
            final int freq = entry.getValue();
            if (freq > 0) {
                for (int i = 1; i < k; i++) { // O(k*logn)
                    final int nextNum = num+i;
                    if (!freqs.containsKey(nextNum)) return false; // O(logn)
                    final int nextNumFreq = freqs.get(nextNum); // O(logn)
                    if (nextNumFreq-freq < 0) return false;
                        freqs.put(nextNum, nextNumFreq-freq); // O(logn)
                }
            }
        }
        
        return true;
    }
}
