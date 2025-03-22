class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
       final var graph = buildGraph(manager);
       return dfs(headID, graph, informTime);
    }

    private static Map<Integer, List<Integer>> buildGraph(int[] manager) {
        final var mgr2emp = new HashMap<Integer, List<Integer>>();
        for (var i = 0; i < manager.length; ++i) {
            mgr2emp.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
        }
        return mgr2emp;
    }

    private static int dfs(int mgr, Map<Integer, List<Integer>> graph, int[] it) {
        if (!graph.containsKey(mgr)) return 0;

        var max = 0;
        for (var emp : graph.get(mgr)) {
            max = Math.max(max, dfs(emp, graph, it));
        }

        return max + it[mgr];
    }
}
