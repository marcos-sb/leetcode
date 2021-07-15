class Solution {
  static class Node {
    boolean terminal;
    Map<Character, Node> next;
    String word;
    Node() {
      next = new HashMap<>();
      terminal = false;
      word = null;
    }
  }

  public String replaceWordsWithPrefix(String[] prefixes, String sentence) {
    final Node trie = new Node();
    
    for (String pref : prefixes) { // O(n)
      Node curr = trie;
      for (int i = 0; i < pref.length(); i++) { // O(nc)
        final char c = pref.charAt(i);
        curr = curr.next.computeIfAbsent(c, k -> new Node());
      }
      curr.terminal = true;
      curr.word = pref;
    }

    final StringBuilder sb = new StringBuilder();
    for (String w : sentence.split(" ")) { // O(m)
      final String prefix = containsPrefix(trie, w); // O(mc)
      if (prefix == null) sb.append(w);
      else sb.append(prefix);
      sb.append(' ');
    }
    sb.setLength(sb.length()-1);

    return sb.toString(); // O(m)
  }

  private static String containsPrefix(Node trie, String s) {
    Node curr = trie;
    for (int i = 0; i < s.length(); i++) {
      final char c = s.charAt(i);
      if (!curr.next.containsKey(c)) return null;
      curr = curr.next.get(c);
      if (curr.terminal) return curr.word;
    }
    return null;
  }
}
