class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final List<List<Integer>> prereqs = new ArrayList<>(numCourses);
        for (var i = 0; i < numCourses; i++)
            prereqs.add(new ArrayList<>());

        for (var p : prerequisites) prereqs.get(p[0]).add(p[1]);

        final var res = new ArrayList<Integer>();
        final var state = new int[numCourses];
        for (var i = 0; i < numCourses; i++)
            if (!dfs(prereqs, i, res, state)) return new int[0];
        
        if (res.size() < numCourses) return new int[0];
        
        final var resArr = new int[numCourses];
        for (var i = 0; i < res.size(); i++) resArr[i] = res.get(i);
        return resArr;
    }
    
    private static boolean dfs(List<List<Integer>> prereqs, int i, List<Integer> res, int[] state) {
        if (state[i] == 2) return true;  // closed
        if (state[i] == 1) return false; // open => cycle
        
        state[i] = 1;
        for (var v : prereqs.get(i))
            if (!dfs(prereqs, v, res, state)) return false;
        state[i] = 2;

        res.add(i);
        return true;
    }
}
