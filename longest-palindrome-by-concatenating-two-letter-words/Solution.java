class Solution {
    public int longestPalindrome(String[] words) {
        final var seen = new HashMap<String, Integer>();
        for (var w : words) seen.put(w, seen.getOrDefault(w, 0) + 1);
        
        final var counted = new HashSet<String>();
        var count = 0;
        var countRepOne = 0;
        final var sb = new StringBuilder(2);
        for (var e : seen.entrySet()) {
            final var w = e.getKey();
            final var wc = e.getValue();
            if (counted.contains(w)) continue;
            if (w.charAt(0) == w.charAt(1)) {
                count += wc/2*4;
                if (wc % 2 == 1) countRepOne = 2;
            } else {
                final var rev = sb.append(w.charAt(1)).append(w.charAt(0)).toString();
                sb.setLength(0);
                final var revCount = seen.getOrDefault(rev, 0);
                count += 4 * Math.min(wc, revCount);
                counted.add(rev);
            }
        }
        
        return count + countRepOne;
    }
}
