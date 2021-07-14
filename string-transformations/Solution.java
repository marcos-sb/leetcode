class Solution {
  public int distance(String beginWord, String endWord, List<String> wordList) {
    wordList.add(beginWord);
    
    final List<List<Integer>> graph = buildGraph(beginWord, wordList);
    int dst = 0;
    while (dst < wordList.size()) {
      if (endWord.equals(wordList.get(dst))) break;
      dst++;
    }
    final int[] cache = new int[wordList.size()];
    final boolean[] visited = new boolean[wordList.size()];
    return dfs(wordList.size()-1, graph, cache, visited, dst);
  }

  private static List<List<Integer>> buildGraph(List<String> wordList) {
    final List<List<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < wordList.size(); i++) {
      graph.add(reachable(i, wordList));
    }

    return graph;
  }

  private static List<Integer> reachable(int srcI, List<String> wordList) {
    final List<Integer> res = new ArrayList<>();
    for (int i = 0; i < wordList.size(); i++) {
      if (distance(wordList.get(srcI), wordList.get(i)) == 1) res.add(i);
    }
    return res;
  }

  private static int distance(String a, String b) {
    if (a.length() != b.length()) return -1;

    int distance = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == b.charAt(i)) continue;
      distance++;
    }

    return distance;
  }

  private static int dfs(int i, List<List<Integer>> graph, int[] cache, boolean[] visited, int dst) {
    if (i == dst) return 0;
    if (visited[i]) return -1;
    if (cache[i] != 0) return cache[i];
    
    visited[i] = true;
    int minPathLen = Integer.MAX_VALUE;
    for (int next : graph.get(i)) {
      if (cache[next] != 0) continue;
      final int res = dfs(next, graph, cache, visited, dst);
      if (res == -1) continue;
      minPathLen = Math.min(minPathLen, 1 + res);
    }
    visited[i] = false;

    cache[i] = (minPathLen == Integer.MAX_VALUE ? -1 : minPathLen);
    return cache[i];
  }
}
