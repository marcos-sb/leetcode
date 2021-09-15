class Solution {
    private static final int[][] movs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    private final Map<Integer, Integer> islandSize = new HashMap<>();
    private int maxExistingIslandSize = 0;
    
    public int largestIsland(int[][] grid) {
        for (var r = 0; r < grid.length; r++) {
            for (var c = 0; c < grid[0].length; c++) {
                bfs(grid, r, c);
            }
        }
        
        var maxSize = 0;
        for (var r = 0; r < grid.length; r++) {
            for (var c = 0; c < grid[0].length; c++) {
                if (grid[r][c] != 0) continue;
                final var set = new HashSet<Integer>(4);
                var curMax = 1;
                for (var mov : movs) {
                    final var newR = r + mov[0];
                    final var newC = c + mov[1];
                    if (outside(grid, newR, newC) || grid[newR][newC] == 0 ||
                        set.contains(grid[newR][newC])) continue;
                    curMax += islandSize.get(grid[newR][newC]);
                    set.add(grid[newR][newC]);
                }
                maxSize = Math.max(maxSize, curMax);
            }
        }
        
        return maxSize == 0 ? maxExistingIslandSize : maxSize;
    }
    
    private void bfs(int[][] grid, int r, int c) {
        if (grid[r][c] <= 0) return;
        
        final var islandIndex = -(islandSize.size()+1);
        final var rows = grid.length;
        final var cols = grid[0].length;
        final var q = new LinkedList<Integer>();
        q.offer(r * cols + c);
        grid[r][c] = islandIndex;

        var islandSize = 0;
        while (!q.isEmpty()) {
            final var cur = q.poll();
            islandSize++;
            
            final var curR = cur / cols;
            final var curC = cur % cols;
            for (var mov : movs) {
                final var newR = curR + mov[0];
                final var newC = curC + mov[1];
                if (outside(grid, newR, newC) || grid[newR][newC] <= 0) continue;
                grid[newR][newC] = islandIndex;
                q.offer(newR * cols + newC);
            }
        }
        
        maxExistingIslandSize = Math.max(maxExistingIslandSize, islandSize);
        this.islandSize.put(islandIndex, islandSize);
    }
    
    private static boolean outside(int[][] grid, int r, int c) {
        return r < 0 || c < 0 || r >= grid.length || c >= grid[0].length;
    }
}
