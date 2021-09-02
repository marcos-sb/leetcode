class Solution {
    public int longestConsecutive(int[] nums) {
        final var candidates = new HashSet<Integer>(nums.length);
        final var longestStarting = new HashMap<Integer, Integer>(nums.length);
        var longest = 0;
        
        for (var n : nums) candidates.add(n);
        for (var n : nums) {
            if (!candidates.contains(n)) continue;
            candidates.remove(n);
            var i = n+1;
            while (candidates.contains(i)) {
                candidates.remove(i);
                i++;
            }
            final var lenFromN = longestStarting.getOrDefault(i, 0) - n + i;
            longestStarting.put(n, lenFromN);
            longest = Math.max(longest, lenFromN);
        }
        
        return longest;
    }
}
