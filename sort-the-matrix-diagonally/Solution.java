class Solution {
    public int[][] diagonalSort(int[][] mat) {
        // left half of diagonal
        for (int row = 0; row < mat.length; row++) {
            sortDiagonal(row, 0, mat);
        }
        
        // right half of diagonal
        for (int col = 1; col < mat[0].length; col++) {
            sortDiagonal(0, col, mat);
        }
        
        return mat;
    }
    
    private static void sortDiagonal(int row, int col, int[][] mat) {
        final List<Integer> sorter = new ArrayList<>();
        int i = row;
        int j = col;
        while (i < mat.length && j < mat[0].length) {
            sorter.add(mat[i++][j++]);
        }

        Collections.sort(sorter);

        i = row;
        j = col;
        for (var n : sorter) {
            mat[i++][j++] = n;
        }
    }
}
