class Solution {
    public boolean checkInclusion(String s1, String s2) {
        final var firstPos = new HashMap<Character, Integer>();
        final var s1map = freqs(s1);
        final var cur = new HashMap<Character, Integer>();
        
        for (var r = 0; r < s2.length(); r++) {
            final var c = s2.charAt(r);
            if (s1map.containsKey(c)) {
                firstPos.putIfAbsent(c, r);
                if (!cur.containsKey(c) || cur.get(c) < s1map.get(c)) {
                    cur.put(c, cur.getOrDefault(c,0)+1);
                    if (cur.equals(s1map)) return true;
                } else {
                    r = firstPos.get(c);
                    cur.clear();
                    firstPos.clear();
                }
            } else {
                cur.clear();
                firstPos.clear();
            }
        }
        
        return false;
    }
    
    private static Map<Character, Integer> freqs(String s) {
        if (s == null) return Map.of();
        final var ret = new HashMap<Character, Integer>();
        for (var i = 0; i < s.length(); i++)
            ret.put(s.charAt(i), ret.getOrDefault(s.charAt(i), 0)+1);
        return ret;
    }
}
