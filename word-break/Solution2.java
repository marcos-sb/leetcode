class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        final var ws = new HashSet<String>();
        for (var _s : wordDict) ws.add(_s);
        final var q = new ArrayDeque<Integer>();
        final var visited = new boolean[s.length()+1];
        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            final var l = q.poll();
            if (l == s.length()) return true;
            for (var r = l+1; r <= s.length(); r++) {
                if (ws.contains(s.substring(l, r)) && !visited[r]) {
                    q.offer(r);
                    visited[r] = true;
                }
            }
        }
        
        return false;
    }
}
