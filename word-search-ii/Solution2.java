class Solution2 {
    static class Node {
        boolean terminal;
        Map<Character, Node> next;
        Node() {
            terminal = false;
            next = new HashMap<>();
        }
    }
    
    private static final int[][] movs = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return List.of();
        
        final var trie = buildTrie(words);
        final var res = new HashSet<String>();
        final var sb = new StringBuilder();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, trie, sb, res);
            }
        }
        
        final List<String> ans = new ArrayList<>(res.size());
        for (var w : res) ans.add(w);
        
        return ans;
    }
    
    private static void dfs(char[][] board, int r, int c, Node root, StringBuilder sb, Set<String> res) {
        final var ch = board[r][c];
        if (!root.next.containsKey(ch)) return;
        
        final var next = root.next.get(ch);
        sb.append(ch);
        board[r][c] = '*';
        if (next.terminal) res.add(sb.toString());
        
        for (var m : movs) {
            final var newR = m[0] + r;
            final var newC = m[1] + c;
            if (invalid(board, newR, newC) || board[newR][newC] == '*') continue;
            dfs(board, newR, newC, next, sb, res);
        }
        
        board[r][c] = ch;
        sb.setLength(sb.length()-1);
    }
    
    private static boolean invalid(char[][] board, int r, int c) {
        return r < 0 || c < 0 || r >= board.length || c >= board[0].length;
    }
    
    private static Node buildTrie(String[] words) {
        final var root = new Node();
        
        for (var w : words) {
            Node curr = root;
            for (int i = 0; i < w.length(); i++) {
                final var c = w.charAt(i);
                curr.next.computeIfAbsent(c, k -> new Node());
                curr = curr.next.get(c);
            }
            curr.terminal = true;
        }
        
        return root;
    }
}
