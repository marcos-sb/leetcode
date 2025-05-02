class Solution {
    static class Node {
        Node[] next;
        boolean terminal;
        Node() {
            this.next = new Node[26];
            this.terminal = false;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        final var n = s.length();
        final var trie = buildTrie(wordDict);
        final var dp = new boolean[n+1];
        final var cs = s.toCharArray();

        dp[0] = true;
        for (var i = 1; i <= n; ++i) {
            if (!dp[i-1]) continue;
            var curr = trie;
            for (var j = i; j <= n; ++j) {
                if (curr.next[cs[j-1]-'a'] != null) {
                    curr = curr.next[cs[j-1]-'a'];
                    dp[j] |= curr.terminal;
                } else {
                    break;
                }
            }
        }

        return dp[n];
    }

    private static Node buildTrie(List<String> wordDict) {
        final var head = new Node();
        for (var word : wordDict) {
            var curr = head;
            for (var c : word.toCharArray()) {
                if (curr.next[c-'a'] == null) curr.next[c-'a'] = new Node();
                curr = curr.next[c-'a'];
            }
            curr.terminal = true;
        }
        return head;
    }
}
