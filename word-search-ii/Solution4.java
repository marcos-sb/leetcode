class Solution {
    private static final int[][] moves = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};

    static class Node {
        final Node[] next;
        int nextCount;
        boolean terminal;
        Node() {
            next = new Node[26];
            nextCount = 0;
            terminal = false;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        final var trie = buildTrie(words);
        final var M = board.length;
        final var N = board[0].length;
        final var res = new ArrayList<String>();
        final var aux = new StringBuilder(M*N);
        for (var r = 0; r < M; r++) {
            for (var c = 0; c < N; c++) {
                dfs(r, c, board, trie, aux, res);
            }
        }
        return res;
    }

    private static Node buildTrie(String[] words) {
        final var root = new Node();
        for (var w : words) {
            var curr = root;
            final var cw = w.toCharArray();
            for (var c : cw) {
                if (curr.next[c-'a'] == null) {
                    curr.next[c-'a'] = new Node();
                    curr.nextCount++;
                }
                curr = curr.next[c-'a'];
            }
            curr.terminal = true;
        }
        return root;
    }

    private static void dfs(int r, int c, char[][] board, Node node, StringBuilder aux, List<String> found) {
        final var ch = board[r][c];
        if (node.next[ch-'a'] == null) return;
        aux.append(ch);
        final var curr = node.next[ch-'a'];
        if (curr.terminal) {
            found.add(aux.toString());
            curr.terminal = false;
        }
        board[r][c] = '.';
        for (var m : moves) {
            final var _r = r + m[0];
            final var _c = c + m[1];
            if (!isValid(_r, _c, board) || board[_r][_c] == '.') continue;
            dfs(_r, _c, board, curr, aux, found);
        }
        aux.setLength(aux.length()-1);
        board[r][c] = ch;
        if (curr.nextCount == 0) {
            node.next[ch-'a'] = null;
            node.nextCount--;
            return;
        }
    }

    private static boolean isValid(int r, int c, char[][] board) {
        return !(r < 0 || c < 0 || board.length <= r || board[0].length <= c);
    }
}
