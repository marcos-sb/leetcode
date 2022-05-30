class Solution {
    public boolean wordPattern(String pattern, String s) {
        final var p2w = new HashMap<Character, String>();
        final var w2p = new HashMap<String, Character>();
        
        var i = 0;
        final var words = s.split(" ");
        if (pattern.length() != words.length) return false;
        for (var w : words) {
            final var p = pattern.charAt(i++);
            final var oldW = p2w.put(p, w);
            if (oldW != null && !w.equals(oldW)) return false;
            final var oldP = w2p.put(w, p);
            if (oldP != null && p != oldP) return false;
        }
        
        return true;
    }
}
