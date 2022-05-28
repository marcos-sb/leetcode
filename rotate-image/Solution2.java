class Solution {
    public void rotate(int[][] matrix) {
        final var N = matrix.length;
        final var top = new int[2];
        final var right = new int[2];
        final var bottom = new int[2];
        final var left = new int[2];
        
        for (var i = 0; i < N/2; i++) {
            top[0] = i; top[1] = i;
            right[0] = i; right[1] = N-1-i;
            bottom[0] = N-1-i; bottom[1] = N-1-i;
            left[0] = N-1-i; left[1] = i;
            while (top[1] < right[1]) {
                var tmp = matrix[right[0]][right[1]];
                matrix[right[0]][right[1]] = matrix[top[0]][top[1]];
                var tmp2 = matrix[bottom[0]][bottom[1]];
                matrix[bottom[0]][bottom[1]] = tmp;
                tmp = matrix[left[0]][left[1]];
                matrix[left[0]][left[1]] = tmp2;
                matrix[top[0]][top[1]] = tmp;

                top[1]++; right[0]++; bottom[1]--; left[0]--;
            }
        }
    }
}
