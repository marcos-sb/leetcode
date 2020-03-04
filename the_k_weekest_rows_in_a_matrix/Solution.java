package the_k_weekest_rows_in_a_matrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        final var soldiers = new int[mat.length];
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 0) continue;
                soldiers[r]++;
            }
        }
        final var count2row = new HashMap<Integer, Queue<Integer>>();
        for (int i = 0; i < soldiers.length; i++) {
            if (!count2row.containsKey(soldiers[i])) {
                count2row.put(soldiers[i], new ArrayDeque<>());
            }
            count2row.get(soldiers[i]).add(i);
        }
        Arrays.sort(soldiers);
        final var res = new int [k];
        for (int i = 0; i < k; i++) {
            res[i] = count2row.get(soldiers[i]).poll();
        }
        return res;
    }
}