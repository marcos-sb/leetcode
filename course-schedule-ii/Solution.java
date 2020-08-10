class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final List<Integer> order = new ArrayList<>(numCourses);
        
        final List<Integer>[] nodes = (ArrayList<Integer>[]) new ArrayList[numCourses];
        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new ArrayList<>();
        
        for (int[] prereq : prerequisites)
             nodes[prereq[0]].add(prereq[1]);
        
        final int[] visited = new int[numCourses];
        for (int src = 0; src < nodes.length; src++)
            if (!complete(nodes, src, order, visited))
                return new int[0];
        
        return order.stream().mapToInt(i->i).toArray();
    }
    
    private boolean complete(List<Integer>[] nodes, Integer src,
                             List<Integer> order, int[] visited) {
        if (visited[src] == 1) return false;     // open
        else if (visited[src] == 2) return true; // closed
        visited[src] = 1;
        
        for (Integer dst : nodes[src])
            if (!complete(nodes, dst, order, visited))
                return false;
        
        order.add(src);
        visited[src] = 2;
        
        return true;
    }
}
