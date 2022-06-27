class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        final List<List<Integer>> res = new ArrayList<>();
        final var aux = new ArrayList<Integer>();
        dfs(graph, 0, aux, res);
        return res;
    }
    
    private void dfs(int[][] graph, int i, List<Integer> aux, List<List<Integer>> res) {
        aux.add(i);
        
        if (i == graph.length-1) res.add(new ArrayList<>(aux));
        else for (var j : graph[i]) dfs(graph, j, aux, res);
        
        aux.remove(aux.size()-1);
    }
}
