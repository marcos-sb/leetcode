import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    private static final int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        final int M = mat.length;
        final int N = mat[0].length;
        final Queue<int[]> q = new ArrayDeque<>();
        final boolean[][] visited = new boolean[M][N];

        for (int r = 0; r < M; ++r) {
            for (int c = 0; c < N; ++c) {
                if (mat[r][c] == 0) {
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] pos = q.poll();
                int r = pos[0];
                int c = pos[1];
                if (mat[r][c] == 1) {
                    mat[r][c] = dist;
                }
                for (int[] m : moves) {
                    int newR = r + m[0];
                    int newC = c + m[1];
                    if (invalid(mat, newR, newC) || visited[newR][newC]) {
                        continue;
                    }
                    visited[newR][newC] = true;
                    q.offer(new int[]{newR, newC});
                }
            }
            dist++;
        }

        return mat;
    }

    private static boolean invalid(int[][] mat, int r, int c) {
        return r < 0 || c < 0 || r >= mat.length || c >= mat[0].length;
    }
}
