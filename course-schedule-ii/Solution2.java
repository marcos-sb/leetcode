class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        final boolean[] visited = new boolean[numCourses];
        final Set<Integer> open = new HashSet<>();
        final List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < graph.size(); i++) {
            if (visited[i]) continue;
            if (!dfs(i, graph, visited, open, res)) return new int[0];
        }
        
        final int[] resArr = new int[res.size()];
        for (int i = 0; i < resArr.length; i++)
            resArr[i] = res.get(i);
        
        return resArr;
    }
    
    private static List<List<Integer>> buildGraph(int courses, int[][] prerequisites) {
        final List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < courses; i++)
            graph.add(new ArrayList<>());

        for (int[] prereq : prerequisites)
            graph.get(prereq[0]).add(prereq[1]);

        return graph;
    }
    
    private static boolean dfs(int i, List<List<Integer>> graph, boolean[] visited, Set<Integer> open, List<Integer> res) {
        if (open.contains(i)) return false;
        
        open.add(i);
        for (int depCourse : graph.get(i)) {
            if (visited[depCourse]) continue;
            if (!dfs(depCourse, graph, visited, open, res)) return false;
        }
        open.remove(i);
        res.add(i);
        
        return visited[i] = true;
    }
}
