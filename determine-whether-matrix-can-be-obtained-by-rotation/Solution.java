class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        return Arrays.deepEquals(mat, target) ||
            rot90(mat, target) || rot180(mat, target) || rot_90(mat, target);
    }

    private static boolean rot90(int[][] mat, int[][] target) {
        final var N = mat.length;
        for (var r = 0; r < N; r++) {
            for (var c = 0; c < N; c++) {
                if (mat[r][c] != target[c][N-1-r]) return false;
            }
        }
        return true;
    }

    private static boolean rot180(int[][] mat, int[][] target) {
        final var N = mat.length;
        for (var r = 0; r < N; r++) {
            for (var c = 0; c < N; c++) {
                if (mat[r][c] != target[N-1-r][N-1-c]) return false;
            }
        }
        return true;
    }

    private static boolean rot_90(int[][] mat, int[][] target) {
        final var N = mat.length;
        for (var r = 0; r < N; r++) {
            for (var c = 0; c < N; c++) {
                if (mat[r][c] != target[N-1-c][r]) return false;
            }
        }
        return true;
    }
}
