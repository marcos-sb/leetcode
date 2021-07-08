class Solution {
  public int decodeWays(String s) {
    final List<List<Integer>> res = new ArrayList<>();
    bt(s, 0, new ArrayList<>(), res);
    return res.size();
  }

  private static void bt(String s, int i, List<Integer> partial, List<List<Integer>> res) {
    if (i == s.length()) {
      res.add(new ArrayList<>(partial));
      return;
    }

    for (int k = 1, j = i; k < 3 && j + k <= s.length(); k++) {
      final int idx = Integer.parseInt(s.substring(j, j+k));
      if (idx == 0) {
        res.clear();
        return;
      }
      if (idx > 26) continue;
      partial.add(idx);
      bt(s, j+k, partial, res);
      partial.remove(partial.size()-1);
    }
  }
}
