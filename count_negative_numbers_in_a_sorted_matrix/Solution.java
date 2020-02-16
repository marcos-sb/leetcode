package count_negative_numbers_in_a_sorted_matrix;

class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int r = grid.length-1; r >= 0; r--) {
            if (grid[r][grid[0].length-1] >= 0) break;
            for (int c = grid[0].length-1; c >= 0; c--) {
                if (grid[r][c] < 0) count++;
                else break;
            }
        }
        return count;
    }
}
