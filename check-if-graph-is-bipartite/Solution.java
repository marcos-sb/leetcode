class Solution {
  public boolean isBipartite(int[][] adjList) {
    if (adjList.length == 0) return true;
    final int[] partition = new int[adjList.length];
    for (int i = 0; i < adjList.length; i++) {
      if (partition[i] != 0) continue;
      if (!dfs(i, adjList, partition, 1)) return false;
    }
    return true;
  }

  private static boolean dfs(int i, int[][] adjList, int[] partition, int part) {
    if (partition[i] != 0 && partition[i] != part) return false;
    if (partition[i] != 0) return true;
    partition[i] = part;

    for (int adj : adjList[i]) {
      if (!dfs(adj, adjList, partition, part*-1)) return false;
    }

    return true;
  }
}
