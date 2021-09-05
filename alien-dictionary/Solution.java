class Solution {
    public String alienOrder(String[] words) {
        final Map<Character, List<Character>> adj = new HashMap<>();
        final Map<Character, Integer> inDeg = new HashMap<>();
        
        // init to '0' to calculate the char set in 'words'
        for (var i = 0; i < words.length; i++)
            for (var j = 0; j < words[i].length(); j++)
                inDeg.put(words[i].charAt(j), 0);
        
        var prev = words[0];
        for (var i = 1; i < words.length; i++) {
            final var cur = words[i];

            // if cur is a prefix of prev, the ordering is wrong
            if (prev.length() > cur.length() && prev.startsWith(cur)) return "";
            for (int j = 0; j < prev.length() && j < cur.length(); j++) {
                final var pc = prev.charAt(j);
                final var cc = cur.charAt(j);
                if (pc == cc) continue;
                
                // keep track of forward ordering: a -> b iff a < b in the alien alphabet
                adj.computeIfAbsent(pc, k -> new ArrayList<>()).add(cc);

                // keep track of how many characters each character depends on
                inDeg.put(cc, inDeg.getOrDefault(cc,0)+1);
                break;
            }
            prev = cur;
        }
        
        // use a queue to store 'free' characters; ie. characters that don't depend on any other (the 'a's in a -> b)
        final var q = new LinkedList<Character>();
        for (var cd : inDeg.entrySet()) {
            if (cd.getValue() == 0) q.offer(cd.getKey());
        }
        
        
        final var res = new StringBuilder();
        while (!q.isEmpty()) {
            final var cur = q.poll();
            // if a character is 'free', it can be added to the result
            // any char is 'free' iff any other character that it depends on is already in 'res'
            res.append(cur);
            for (var curNext : adj.getOrDefault(cur, List.of())) {
                inDeg.put(curNext, inDeg.get(curNext)-1);
                if (inDeg.get(curNext) == 0) q.offer(curNext);
            }
        }
        
        // if we couldn't 'free' all characters => cycles in 'adj' => wrong ordering of 'words'
        if (res.length() < inDeg.size()) return "";
        
        return res.toString();
    }
}
