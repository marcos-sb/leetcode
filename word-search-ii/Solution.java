public class Solution {
    static final int[][] movs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    static class TrieNode {
        boolean terminal;
        Map<Character, TrieNode> next;
        TrieNode() {
            this.terminal = false;
            this.next = new HashMap<>();
        }
    }

    public List<String> wordSearchII(char[][] board, List<String> words) {
        final TrieNode root = buildTrie(words);

        final Set<String> res = new HashSet<>();
        final StringBuilder sb = new StringBuilder();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(r,c,board,new boolean[board.length][board[0].length],root,sb,res);
            }
        }

        return new ArrayList<>(res);
    }

    private static TrieNode buildTrie(List<String> words) {
        final TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (int i = 0; i < w.length(); i++) {
                final char c = w.charAt(i);
                node.next.computeIfAbsent(c, k -> new TrieNode());
                node = node.next.get(c);
            }
            node.terminal = true;
        }
        return root;
    }

    private static void dfs(int r, int c, char[][] board, boolean[][] visited, TrieNode node, StringBuilder sb, Set<String> res) {
        final char ch = board[r][c];
        if (!node.next.containsKey(ch)) return;

        node = node.next.get(ch);
        
        if (node.terminal) res.add(sb.toString());

        sb.append(ch);
        visited[r][c] = true;
        for (int[] m : movs) {
            final int newR = r + m[0];
            final int newC = c + m[1];
            if (!isValid(newR, newC, board) || visited[newR][newC]) continue;
            dfs(newR, newC, board, visited, node, sb, res);
        }
        sb.setLength(sb.length()-1);
        visited[r][c] = false;
    }

    private static boolean isValid(int r, int c, char[][] board) {
        return !(r < 0 || r >= board.length || c < 0 || c >= board[0].length);
    }
}
