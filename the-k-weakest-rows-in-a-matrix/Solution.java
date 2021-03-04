class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        final var soldiers = new int[mat.length][2];
        for (int r = 0; r < mat.length; r++) {
            int soldierCount = 0;
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 0) break;
                soldierCount++;
            }
            soldiers[r][0] = soldierCount;
            soldiers[r][1] = r;
        }
        
        Arrays.sort(soldiers, (a,b) -> a[0] - b[0]);
        
        final var res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = soldiers[i][1];
        }
        
        return res;
    }
}
