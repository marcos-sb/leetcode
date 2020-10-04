class Solution {
    static class Node {
        boolean terminal;
        Map<Character, Node> next;
        Node() {
            terminal = false;
            next = new HashMap<>('z'-'a'+1);
        }
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        final Node trieHead = populateTrie(wordDict);
        final var dp = new boolean[s.length()+1]; // keep track of all the possible starting points for a word
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) continue; // if it's not a possible starting point for a dict word, try the next index
            Node curr = trieHead;
            for (int j = i; j < s.length(); j++) {
                if (!curr.next.containsKey(s.charAt(j))) break;
                curr = curr.next.get(s.charAt(j));
                if (curr.terminal) dp[j+1] = curr.terminal;
            }
            if (dp[s.length()]) return true;
        }
        return dp[s.length()];
    }
    
    private static Node populateTrie(List<String> words) {
        final Node root = new Node();
        for (var w : words) {
            Node curr = root;
            for (int i = 0; i < w.length(); i++) {
                curr.next.computeIfAbsent(w.charAt(i), k -> new Node());
                curr = curr.next.get(w.charAt(i));
            }
            curr.terminal = true;
        }
        return root;
    }
}
