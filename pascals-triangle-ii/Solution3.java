class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return List.of(1);
        
        final var aux = new Integer[2][rowIndex+1];
        var cur = 0;
        var next = 1;
        aux[cur][0] = 1; aux[cur][1] = 1;
        aux[next][0] = 1;
        for (var row = 1; row < rowIndex; row++) {
            for (var i = 1; i <= row; i++) {
                aux[next][i] = aux[cur][i-1] + aux[cur][i];
            }
            aux[next][row+1] = 1;
            cur++; cur %= 2;
            next++; next %= 2;
        }

        return List.of(aux[cur]);
    }
    
    
}
