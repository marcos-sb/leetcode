class Solution {
    private static final int[][] neighbourDeltas = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        final Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                if (grid[r][c] == 2) q.offer(new int[]{r,c});
                else if (grid[r][c] == 1) freshCount++;
        
        if (freshCount == 0) return 0;

        int days = -1;
        while (!q.isEmpty()) {
            ++days;
            int size = q.size();
            while (size-- > 0) {
                final int[] curr = q.poll();
                for (int[] n : neighbours(grid, curr[0], curr[1])) {
                    if (grid[n[0]][n[1]] == 1) {
                        q.offer(n);
                        freshCount--;
                        grid[n[0]][n[1]] = 2;
                    }
                }
            }
        }
        
        return freshCount == 0 ? days : -1;
    }
    
    private static List<int[]> neighbours(int[][] grid, int r, int c) {
        final var res = new ArrayList<int[]>(neighbourDeltas.length);
        for (int[] nd : neighbourDeltas) {
            final int[] newN = {r+nd[0], c+nd[1]};
            if (newN[0] < 0 || newN[0] >= grid.length ||
                newN[1] < 0 || newN[1] >= grid[0].length) {
                continue;
            }
            res.add(newN);
        }
        return res;
    }
}
