class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        final var accessible = new boolean[n];
        for (var e : edges)
            accessible[e.get(1)] = true;
        
        final var res = new ArrayList<Integer>(n);
        for (var i = 0; i < n; i++) {
            if (!accessible[i]) res.add(i);
        }
        
        return res;
    }
}
