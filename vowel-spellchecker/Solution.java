class Solution {
    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    private static class Node {
        final Map<Character, Node> next;
        final LinkedHashMap<String, Boolean> terminals;
        Node() {
            next = new HashMap<>();
            terminals = new LinkedHashMap<>(16, 0.75F, false);
        }
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        final Node trie = new Node();
        for (final String word : wordlist) {
            add(trie, word);
        }

        final var res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            final var word = queries[i];
            final var cands = getCandidates(trie, word);

            if (cands.isEmpty()) res[i] = "";
            else if (cands.containsKey(word)) res[i] = word;
            else res[i] = findOtherMatch(cands, word);
        }

        return res;
    }

    private static void add(Node trie, String word) {
        final String wordLC = word.toLowerCase();
        Node curr = trie;
        for (int i = 0; i < wordLC.length(); i++) {
            char c = wordLC.charAt(i);
            if (vowels.contains(c)) c = '*';
            curr.next.putIfAbsent(c, new Node());
            curr = curr.next.get(c);
        }
        curr.terminals.put(word, true);
    }

    private static LinkedHashMap<String, Boolean> getCandidates(Node trie, String word) {
        final String wordLC = word.toLowerCase();
        Node curr = trie;
        for (int i = 0; i < wordLC.length(); i++) {
            char c = wordLC.charAt(i);
            if (vowels.contains(c)) c = '*';
            if (!curr.next.containsKey(c)) return new LinkedHashMap<>();
            curr = curr.next.get(c);
        }
        return curr.terminals;
    }

    private static String findOtherMatch(LinkedHashMap<String, Boolean> cands, String word) {
        for (var cand : cands.keySet())
            if (cand.equalsIgnoreCase(word)) return cand;
        for (var cand : cands.keySet())
            if (equalsIgnoreCaseAndVowels(cand, word)) return cand;
        return "";
    }

    private static boolean equalsIgnoreCaseAndVowels(String cand, String word) {
        if (cand.length() != word.length()) return false;
        for (int i = 0; i < cand.length(); i++) {
            final var cc = Character.toLowerCase(cand.charAt(i));
            final var cw = Character.toLowerCase(word.charAt(i));
            if (vowels.contains(cc) == vowels.contains(cw)) continue;
            if (cc != cw) return false;
        }
        return true;
    }
}
