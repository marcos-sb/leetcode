class Solution {
    static class Node {
        boolean terminal;
        Map<Character, Node> next;
        Node() {
            terminal = false;
            next = new HashMap<>();
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty() || wordDict.isEmpty())
            return List.of();
        
        final var dict = initTrie(wordDict);
        final Set<List<String>> res = new HashSet<>();
        
        aux(s, 0, dict, new ArrayList<>(), res);
        
        final var resLst = new ArrayList<String>();
        final var sb = new StringBuilder();
        for (var sentence : res)
            resLst.add(String.join(" ", sentence));
        
        return resLst;
    }
    
    private static void aux(String s, int i, Node root, List<String> sentence, Set<List<String>> res) {
        if (i == s.length()) {
            res.add(new ArrayList<>(sentence));
            return;
        }
        
        Node curr = root;
        for (int j = i; j < s.length(); j++) {
            final var c = s.charAt(j);
            if (!curr.next.containsKey(c)) break;
            curr = curr.next.get(c);
            if (curr.terminal) {
                sentence.add(s.substring(i, j+1));
                aux(s, j+1, root, sentence, res);
                sentence.remove(sentence.size()-1);
            }
        }
    }
    
    private static Node initTrie(List<String> words) { // O(W)
        final var root = new Node();
        for (String w : words) { // O(w*max(len(w))) => O(W)
            Node curr = root;
            for (int i = 0; i < w.length(); i++) { // O(len(w))
                final var c = w.charAt(i);
                curr.next.computeIfAbsent(c, k -> new Node());
                curr = curr.next.get(c);
            }
            curr.terminal = true;
        }
        return root;
    }
}
