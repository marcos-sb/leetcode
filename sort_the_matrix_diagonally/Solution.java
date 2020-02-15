package sort_the_matrix_diagonally;

import java.util.PriorityQueue;

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for (int r = 0; r < mat.length; r++) {
            sortInPlace(r, 0, mat);
        }
        for (int c = 1; c < mat[0].length; c++) {
            sortInPlace(0, c, mat);
        }
        return mat;
    }
    private void sortInPlace(int ri, int ci, int[][] mat) {
        int r = ri;
        int c = ci;
        final var pq = new PriorityQueue<Integer>();
        while (r < mat.length && c < mat[0].length) {
            pq.add(mat[r++][c++]);
        }
        r = ri;
        c = ci;
        while (r < mat.length && c < mat[0].length) {
            mat[r++][c++] = pq.poll();
        }
    }
}
