class Solution {
    private static final int[][] moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public int[][] updateMatrix(int[][] mat) {
        final var zeros = zeros(mat);
        final var q = new LinkedList<int[]>();
        final var visited = new HashSet<Integer>();
        for (var pos : zeros) {
            q.offer(pos);
            visited.add(pos[0]*mat[0].length + pos[1]);
        }
        
        var distance = 0;
        while (!q.isEmpty()) {
            var size = q.size();
            while (size-- > 0) {
                final var cur = q.poll();
                mat[cur[0]][cur[1]] = distance;
                for (var m : moves) {
                    final var newR = cur[0] + m[0];
                    final var newC = cur[1] + m[1];
                    final var index = newR*mat[0].length + newC;
                    if (invalid(mat, newR, newC) || visited.contains(index))
                        continue;
                    visited.add(index);
                    q.offer(new int[]{newR, newC});
                }
            }
            distance++;
        }
        
        return mat;
    }
    
    private static List<int[]> zeros(int[][] mat) {
        final var ret = new ArrayList<int[]>();
        for (var r = 0; r < mat.length; r++) {
            for (var c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 0) ret.add(new int[]{r,c});
            }
        }
        return ret;
    }
    
    private static boolean invalid(int[][] mat, int r, int c) {
        return r < 0 || c < 0 || r >= mat.length || c >= mat[0].length;
    }
}
