class Solution {
    public String alienOrder(String[] words) {
        final Map<Character, List<Character>> adj = new HashMap<>();
        final var charset = new boolean[26];
        
        for (var i = 0; i < words.length; i++)
            for (var j = 0; j < words[i].length(); j++)
                charset[words[i].charAt(j)-'a'] = true;
        
        var prev = words[0];
        for (var i = 1; i < words.length; i++) {
            final var cur = words[i];
            if (prev.length() > cur.length() && prev.startsWith(cur)) return "";
            for (int j = 0; j < prev.length() && j < cur.length(); j++) {
                final var pc = prev.charAt(j);
                final var cc = cur.charAt(j);
                if (pc == cc) continue;
                adj.computeIfAbsent(cc, k -> new ArrayList<>()).add(pc);
                break;
            }
            prev = cur;
        }
        
        final var color = new int[26];
        final var res = new StringBuilder();
        for (var i = 0; i < charset.length; i++) {
            if (!charset[i]) continue;
            if(!dfs(adj, (char)(i+'a'), color, res)) return "";
        }
        
        return res.toString();
    }
    
    private static boolean dfs(Map<Character, List<Character>> adj, char c, int[] color, StringBuilder res) {
        final var idx = c-'a';
        if (color[idx] == 1) return false;
        if (color[idx] == 2) return true;
        color[idx] = 1;
        
        for (var nextChar : adj.getOrDefault(c, List.of())) {
            if (color[nextChar-'a'] == 2) continue;
            if (!dfs(adj, nextChar, color, res)) return false;
        }
        
        res.append(c);
        color[idx] = 2;
        return true;
    }
}
