class Solution {
    static class Pos extends Pair<Integer,Integer> {
        Pos(Integer k, Integer v) { super(k,v); }
    }
    private static int[][] neighDeltas = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public int uniquePathsIII(int[][] grid) {
        int nonObstacles = 1; // include 'start' position
        Pos start = null, end = null;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 0) nonObstacles++;
                else if (grid[i][j] == 1) start = new Pos(i,j);
                else if (grid[i][j] == 2) end = new Pos(i,j);
        if (start == null || end == null) return 0;
        return dfs(grid, start, end, new HashSet<>(), nonObstacles);
    }
    private static int dfs(int[][] grid, Pos start, Pos end, Set<Pos> visited, int nonObstacles) {
        if (start.equals(end)) return visited.size() == nonObstacles ? 1 : 0;
        if (grid[start.getKey()][start.getValue()] == -1) return 0;
        if (visited.contains(start)) return 0;
        visited.add(start);
        int ways = 0;
        for (Pos p : neighbours(grid, start, visited))
            ways += dfs(grid, p, end, visited, nonObstacles);
        visited.remove(start);
        return ways;
    }
    private static List<Pos> neighbours(int[][] grid, Pos pos, Set<Pos> visited) {
        final List<Pos> ret = new ArrayList<>(4);
        for (int[] d : neighDeltas) {
            final Pos p = new Pos(d[0] + pos.getKey(), d[1] + pos.getValue());
            if (isValid(grid, p) && !visited.contains(p)) ret.add(p);
        }
        return ret;
    }
    private static boolean isValid(int[][] grid, Pos pos) {
        return 0 <= pos.getKey() && pos.getKey() < grid.length &&
            0 <= pos.getValue() && pos.getValue() < grid[0].length;
    }
}
