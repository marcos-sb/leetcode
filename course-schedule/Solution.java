class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());
        
        for (int[] p : prerequisites)
            adj.get(p[0]).add(p[1]);
        
        final Set<Integer> open = new HashSet<>();
        final Set<Integer> closed = new HashSet<>();
        for (int i = 0; i < numCourses; i++)
            if (!dfs(adj, i, open, closed)) return false;
        
        return true;
    }
    
    private static boolean dfs(List<List<Integer>> adj, int c, Set<Integer> open, Set<Integer> closed) {
        if (open.contains(c)) return false;
        if (closed.contains(c)) return true;
        
        open.add(c);
        for (int neigh : adj.get(c)) {
            if (!dfs(adj, neigh, open, closed)) return false;
        }
        open.remove(c);
        closed.add(c);
        
        return true;
    }
}
