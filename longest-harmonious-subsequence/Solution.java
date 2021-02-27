class Solution {
    public int findLHS(int[] nums) {
        final var freq = new HashMap<Integer, Integer>(nums.length/2);
        for (var n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        
        int maxLength = 0;
        for (var entry : freq.entrySet()) {
            if (freq.containsKey(entry.getKey()+1))
                maxLength = Math.max(maxLength, entry.getValue() + freq.get(entry.getKey()+1));
        }
        
        return maxLength;
    }
}
